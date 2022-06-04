package cn.fastword.word;

import cn.fastword.word.AbstractIBasicWord;
import cn.fastword.word.enums.FastDocument;
import cn.fastword.word.handller.ITableBeans;
import cn.hutool.core.io.FileUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 构建pdf文档
 *
 * @author wanghe
 */
public class PdfFileWriter extends AbstractIBasicWord {
    /**
     * 默认正文字体
     */
    private Font defaultFont = new Font(Font.FontFamily.HELVETICA, DEFAULT_SIZE, DEFAULT_BOLD ? Font.BOLD : Font.ITALIC);
    /**
     * 默认标题头字体
     */
    private final Font defaultHeaderFont = new Font(Font.FontFamily.HELVETICA, TITLE_SIZE, DEFAULT_BOLD ? Font.BOLD : Font.ITALIC);
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
        for (String content : texts) {
            try {
                Paragraph elements = new Paragraph(content, this.defaultFont);
                elements.setAlignment((Integer) alignment);
                this.document.add(elements);
            } catch (DocumentException e) {
                throw new RuntimeException("==> Preparing:添加段落失败(ERROR): ", e);
            }
        }
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
    private void addDocumentExtra() {
        this.document.addCreator(System.getProperty("os.name"));
        this.document.addAuthor(System.getProperty("user.name"));
        this.document.addCreationDate();
        this.writer.setPdfVersion(PdfWriter.VERSION_1_7);
    }

    public String getDocumentFile() {
        try {
            this.addDocumentExtra();
            this.document.close();
            this.writer.close();
            logger.info("==> Preparing: {}", this.documentFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return documentFile.getAbsolutePath();
    }

    public Document getDocument() {
        return document;
    }

    public PdfWriter getWriter() {
        return writer;
    }
}
