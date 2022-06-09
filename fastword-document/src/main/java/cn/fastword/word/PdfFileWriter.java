package cn.fastword.word;

import cn.fastword.word.beans.TableBeans;
import cn.fastword.word.enums.FastDocument;
import cn.fastword.word.handller.DefaultAnnotationTableHandler;
import cn.fastword.word.handller.DefaultTableBeansHandler;
import cn.fastword.word.handller.ITableBeans;
import cn.fastword.word.table.IFastDocumentTable;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 构建pdf文档
 *
 * @author wanghe
 */
public class PdfFileWriter extends AbstractIBasicWord implements IFastDocumentTable<Map<String, Object>> {
    private final BaseFont CHINESE_FONT = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    /**
     * 常规字体
     */
    private Font BASE_FONT = new Font(this.CHINESE_FONT, (DEFAULT_SIZE - 4), DEFAULT_BASE_BOLD ? Font.BOLD : Font.NORMAL);
    /**
     * 加粗字体
     */
    private final Font BOLD_FONT = new Font(this.CHINESE_FONT, DEFAULT_SIZE, Font.BOLD);
    /**
     * 默认标题头字体-加粗
     */
    private final Font DEFAULT_HEADER_FONT = new Font(this.CHINESE_FONT, (TITLE_SIZE - 2), Font.BOLD);

    private final Document document = new Document();

    private PdfWriter writer = null;

    private File documentFile = null;

    public PdfFileWriter(File file) throws DocumentException, IOException {
        this(file.getName(), file.getParentFile().getAbsolutePath());
    }

    public PdfFileWriter(String fileName, String savePath) throws DocumentException, IOException {
        this.documentFile = this.getDocumentFile(fileName, savePath, FastDocument.PDF);
        this.writer = PdfWriter.getInstance(this.document, new FileOutputStream(FileUtil.file(this.createNewFile(this.documentFile))));
        this.document.open();
        this.document.newPage();
    }

    @Override
    public void addHeader(String title, String... headers) {
        this.addParagraphRows(title);
    }

    @Override
    public <A, B> void addParagraphRows(final A alignment, final B defaultFont, String... contents) {
        for (int i = 0; i < contents.length; i++) {
            try {
                Paragraph elements = new Paragraph(contents[i], i == 0 ? this.BOLD_FONT : (Font) defaultFont);  // 默认首行加粗
                this.document.add(elements);
            } catch (DocumentException e) {
                throw new RuntimeException("==> Preparing:添加段落失败(ERROR): ", e);
            }
        }
    }

    @Override
    public void addParagraphRows(String... contents) {
        this.addParagraphRows(Element.ALIGN_LEFT, this.BASE_FONT, contents);
    }

    @Override
    public void addParagraphPictureRows(File picture, String... contents) {
        this.addParagraphRows(contents);
        this.addPicture(picture);
    }

    @Override
    public void addPicture(File picture) {
        Rectangle rectangle = this.document.getPageSize();
        this.addPicture(picture, (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    @Override
    public void addPicture(InputStream stream, String fileName) {
        try {
            Image image = Image.getInstance(IoUtil.readBytes(stream));
            image.scaleToFit(this.defaultWidth, this.defaultHeight);
            this.document.add(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPicture(File picture, int defaultWidth, int defaultHeight) {
        try {
            Image image = Image.getInstance(picture.getAbsolutePath());
            image.scaleToFit(defaultWidth, defaultHeight);
            image.setAlignment(Image.LEFT);
            this.document.add(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBlankRow() {
        try {
            this.document.add(Chunk.NEWLINE);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void addTable(TableBeans tableBeans) {
        this.addTable(new DefaultTableBeansHandler(tableBeans));
    }

    @Override
    public void addParagraphTableRows(TableBeans tableBeans, String... contents) {
        this.addParagraphRows(Element.ALIGN_LEFT, this.BASE_FONT, contents);
        this.addBlankRow();
        this.addTable(tableBeans);
    }

    @Override
    public void addParagraphTableRows(List<?> beans, Class<?> beanCls, String... contents) {
        this.addParagraphTableRows(new DefaultAnnotationTableHandler(beans, beanCls), contents);
    }

    @Override
    public void addParagraphTableRows(ITableBeans<Map<String, Object>> handler, String... contents) {
        this.addParagraphRows(Element.ALIGN_LEFT, this.BASE_FONT, contents);
        this.addBlankRow();
        this.addTable(handler);
    }

    public void addTable(PdfPTable table) throws DocumentException {
        this.document.add(table);
    }

    @Override
    public void addTable(ITableBeans<Map<String, Object>> handler) {
        List<Map<String, Object>> tableList = handler.createTable();
        if (tableList != null && tableList.size() > 0) {
            try {
                PdfPTable table = this.addHeader(Objects.requireNonNull(tableList).get(0));
                for (int i = 0; i < tableList.size(); i++)
                    tableList.get(i).values().forEach(header -> table.addCell(this.addCell(header, new Font(this.CHINESE_FONT,
                            this.BASE_FONT.getSize(), Font.NORMAL), false)));
                table.setWidthPercentage(100);
                this.addTable(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void addWatermark(String watermark) {
        PdfContentByte content = this.writer.getDirectContent();
        content.setGState(new PdfGState());
        content.beginText();
        content.setColorFill(BaseColor.LIGHT_GRAY);
        content.setFontAndSize(this.CHINESE_FONT, 20);
        content.showTextAligned(Element.ALIGN_BASELINE, watermark, 180, 340, 45);
        content.endText();
    }

    /**
     * 表格表头
     *
     * @param headers 数据对象
     * @return PdfPTable
     */
    protected PdfPTable addHeader(Map<String, Object> headers) {
        LinkedList<String> headerList = new LinkedList<>(headers.keySet());
        PdfPTable table = new PdfPTable(headerList.size());
        headerList.forEach(header -> table.addCell(this.addCell(header, new Font(this.CHINESE_FONT, this.BOLD_FONT.getSize(), Font.BOLD), true)));
        return table;
    }

    /**
     * 表格列
     *
     * @param content     文本
     * @param defaultFont 字体
     * @return PdfPCell
     */
    protected PdfPCell addCell(Object content, Font defaultFont, boolean backgroundColor) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(content + "", defaultFont));
        if (backgroundColor)
            cell.setBackgroundColor(new BaseColor(221, 126, 107));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderColorBottom(new BaseColor(0, 0, 0));
        cell.setBorderColorLeft(new BaseColor(0, 0, 0));
        cell.setBorderColorRight(new BaseColor(0, 0, 0));
        cell.setBorderColorTop(new BaseColor(0, 0, 0));
        return cell;
    }

    /**
     * 文档额外信息
     */
    private void addDocumentExtra() {
        this.document.addCreator(System.getProperty("os.name"));
        this.document.addAuthor(System.getProperty("user.name"));
        this.document.addCreationDate();
        this.writer.setPdfVersion(PdfWriter.VERSION_1_7);
    }

    @Override
    protected File saveWordFile(File file) {
        try {
            this.addDocumentExtra();
            this.document.close();
            this.writer.close();
            logger.info("==> Preparing: {}", this.documentFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public String getDocumentFile() throws IOException {
        return this.saveWordFile(this.createNewFile(this.documentFile)).getAbsolutePath();
    }

    public Document getDocument() {
        return document;
    }

    public PdfWriter getWriter() {
        return writer;
    }

    public PdfFileWriter setBASE_FONT(Font BASE_FONT) {
        this.BASE_FONT = BASE_FONT;
        return this;
    }
}
