package cn.fastword.word;

import cn.fastword.word.beans.TableBeans;
import cn.fastword.word.enums.FastDocument;
import cn.fastword.word.handller.DefaultAnnotationTableHandler;
import cn.fastword.word.handller.DefaultTableBeansHandler;
import cn.fastword.word.handller.ITableBeans;
import cn.fastword.word.table.IFastDocumentTable;
import cn.hutool.core.io.FileUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

/**
 * 构建pdf文档
 *
 * @author wanghe
 */
public class PdfFileWriter extends AbstractIBasicWord implements IFastDocumentTable<Map<String, Object>> {
    private final BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    /**
     * 默认正文字体
     */
    private Font defaultFont = new Font(baseFont, DEFAULT_SIZE, DEFAULT_BOLD ? Font.ITALIC : Font.NORMAL);
    /**
     * 默认标题头字体
     */
    private final Font defaultHeaderFont = new Font(baseFont, TITLE_SIZE, DEFAULT_BOLD ? Font.BOLD : Font.NORMAL);
    /**
     * 文档对象
     */
    private final Document document = new Document();

    private PdfWriter writer = null;

    private File documentFile = null;

    public PdfFileWriter(File file) throws DocumentException, IOException {
        this(file.getName(), file.getParentFile().getAbsolutePath());
    }

    public PdfFileWriter(String fileName, String savePath) throws DocumentException, IOException {
        this.documentFile = this.getDocumentFile(fileName, savePath, FastDocument.PDF);
        this.writer = PdfWriter.getInstance(this.document, new FileOutputStream(FileUtil.file(this.documentFile)));
        this.document.open();
        this.document.newPage();
    }

    @Override
    public void addHeader(String title, String... headers) {
        this.addParagraphRows(title);
    }

    @Override
    public <A, B> void addParagraphRows(A alignment, B defaultFont, String... texts) {
        this.defaultFont = (Font) defaultFont;
        Arrays.stream(texts).forEach(content -> {
            try {
                Paragraph elements = new Paragraph(content, this.defaultFont);
                this.document.add(elements);
                this.addBlankRow();
            } catch (DocumentException e) {
                throw new RuntimeException("==> Preparing:添加段落失败(ERROR): ", e);
            }
        });
    }

    @Override
    public void addParagraphRows(String... texts) {
        this.addParagraphRows(TabStop.Alignment.LEFT, defaultFont, texts);
    }

    @Override
    public void addParagraphPictureRows(File picture, String... texts) {

    }

    @Override
    public void addPicture(File picture) {

    }

    @Override
    public void addPicture(InputStream stream, String fileName) {

    }

    @Override
    public void addPicture(File picture, int defaultWidth, int defaultHeight) {

    }

    @Override
    public void addBlankRow() {
        try {
            this.document.add(new Paragraph(""));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTable(ITableBeans<Map<String, Object>> handler) {
        List<Map<String, Object>> tableList = handler.createTable();
        if (tableList != null && tableList.size() > 0) {
            try {
                PdfPTable table = addHeader(Objects.requireNonNull(tableList).get(0));
                for (int i = 0; i < tableList.size(); i++)
                    tableList.get(i).values().forEach(header -> this.addCell(header, new Font(this.baseFont, DEFAULT_SIZE, Font.NORMAL)));
                table.setWidthPercentage(100);
                this.document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

    }

    public void addTable(TableBeans tableBeans) {
        try {
            this.addTable(new DefaultTableBeansHandler(tableBeans));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addParagraphTableRows(TableBeans tableBeans, String... texts) {
        this.addParagraphRows(TabStop.Alignment.LEFT, this.defaultFont, texts);
        this.addTable(tableBeans);
        this.addBlankRow();
    }

    @Override
    public void addParagraphTableRows(List<?> beans, Class<?> beanCls, String... texts) {
        this.addParagraphTableRows(new DefaultAnnotationTableHandler(beans, beanCls), texts);
    }

    @Override
    public void addParagraphTableRows(ITableBeans<Map<String, Object>> handler, String... texts) {
        this.addParagraphRows(TabStop.Alignment.LEFT, this.defaultFont, texts);
        this.addTable(handler);
        this.addBlankRow();
    }

    /**
     * 表格表头
     *
     * @param headers 数据对象
     * @return PdfPTable
     */
    private PdfPTable addHeader(Map<String, Object> headers) {
        LinkedList<String> headerList = new LinkedList<>(headers.keySet());
        PdfPTable table = new PdfPTable(headerList.size());
        headerList.forEach(header -> table.addCell(this.addCell(header, new Font(this.baseFont, DEFAULT_SIZE, Font.BOLD))));
        return table;
    }

    /**
     * 表格列
     *
     * @param content     文本
     * @param defaultFont 字体
     * @return PdfPCell
     */
    private PdfPCell addCell(Object content, Font defaultFont) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase((String) content, defaultFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
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
            this.document.close();
            this.writer.close();
            logger.info("==> Preparing: {}", this.documentFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public String getDocumentFile() {
        this.addDocumentExtra();
        return this.saveWordFile(this.documentFile).getAbsolutePath();
    }

    public Document getDocument() {
        return document;
    }

    public PdfWriter getWriter() {
        return writer;
    }
}
