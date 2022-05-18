package com.fast.word;

import cn.hutool.core.io.FileUtil;
import com.fast.word.beans.TableBeans;
import com.fast.word.enums.Documents;
import com.fast.word.handller.ITableBeansHandler;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * pdf操作
 *
 * @author wanghe
 */
public class PdfFileWriter extends AbstractIBasicWord {

    private PdfWriter pdfWriter;

    private Document document;
    /**
     * 输出路径
     */
    private String fileName;

    /**
     * 构造
     *
     * @param filename 文件全路径
     */
    public PdfFileWriter(String filename, String savePath) throws Exception {
        this.document = new Document();
        this.fileName = filename;
        this.pdfWriter = PdfWriter.getInstance(this.document, new FileOutputStream(this.getDocumentFile(filename, savePath)));
        this.document.open();
    }

    /**
     * 获取全局默认字体
     */
    private com.itextpdf.text.Font getDefaultFont(Font defaultFont) {
        com.itextpdf.text.Font textFont = new com.itextpdf.text.Font();
        textFont.setSize(defaultFont.getSize());
        textFont.setFamily(defaultFont.getFontName());
        textFont.setColor(BaseColor.RED);
        if (defaultFont.isBold()) {
            textFont.isBold();
        }
        return textFont;
    }


    @Override
    public void addHeader(String title, String... headers) {
        try {
            this.document.add(new Paragraph(title, this.getDefaultFont(this.defaultHeaderFont)));
            this.addParagraphRows(headers);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addParagraphRows(ParagraphAlignment alignment, Font defaultFont, String... texts) {

    }

    @Override
    public void addParagraphRows(String... texts) {
        try {
            for (String text : texts) {
                this.document.add(new Paragraph(text, this.getDefaultFont(this.defaultFont)));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
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
    public String getDocumentFile(String fileName, String savePath) {
        File file = FileUtil.file(this.getDocumentFile(fileName, savePath, Documents.PDF));
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        return file.getAbsolutePath();
    }

    public String getDocumentFile() {
        this.document.close();
        this.pdfWriter.close();
        return "";
    }

    @Override
    public void addTable(ITableBeansHandler handler) {

    }

    @Override
    public void addParagraphTableRows(ITableBeansHandler handler, String... texts) {

    }

    @Override
    public void addTable(TableBeans tableBeans) {

    }

    @Override
    public void addParagraphTableRows(TableBeans tableBeans, String... texts) {

    }
}
