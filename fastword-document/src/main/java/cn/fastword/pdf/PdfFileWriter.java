package cn.fastword.pdf;

import cn.fastword.word.AbstractIBasicWord;
import cn.fastword.word.enums.FastDocument;
import cn.fastword.word.handller.ITableBeans;
import cn.hutool.core.io.FileUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 构建pdf文档
 *
 * @author wanghe
 */
public class PdfFileWriter extends AbstractIBasicWord<Integer> {
    /**
     * 文档对象
     */
    private final Document document = new Document();

    private PdfWriter writer = null;

    private File file = null;

    public PdfFileWriter(String fileName, String savePath) {
        try {
            this.file = new File(this.getDocumentFile(fileName, savePath, FastDocument.PDF));
            this.writer = PdfWriter.getInstance(this.document, new FileOutputStream(FileUtil.file(file)));
            this.writer.setPdfVersion(PdfWriter.VERSION_1_7);
            this.document.open();
            this.document.newPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addHeader(String title, String... headers) {
        this.addParagraphRows(title);
    }

    @Override
    public void addParagraphRows(Integer alignment, Font defaultFont, String... texts) {
        Arrays.stream(texts).forEach(content -> {
            try {
                Paragraph elements = new Paragraph(content);
                elements.setFont(new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, defaultFont.getSize(), com.itextpdf.text.Font.BOLD));
                elements.setAlignment(alignment);
                this.document.add(elements);
            } catch (DocumentException e) {
                throw new RuntimeException("添加段落失败->", e);
            }
        });
    }

    @Override
    public void addParagraphRows(String... text) {

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

    }

    @Override
    public void addTable(ITableBeans<?> handler) {

    }

    @Override
    public void addParagraphTableRows(ITableBeans<?> handler, String... texts) {

    }

    /**
     * 文档额外信息
     */
    private void addExtra() {
        this.document.addCreator(System.getProperty("os.name"));
        this.document.addAuthor(System.getProperty("user.name"));
        this.document.addCreationDate();
    }

    public String getDocumentFile() {
        this.addExtra();
        this.document.close();
        this.writer.close();
        logger.info("==> Preparing: {}", this.file);
        return file.getAbsolutePath();
    }

    public Document getDocument() {
        return document;
    }
}
