package com.fast.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.word.PicType;
import cn.hutool.poi.word.Word07Writer;
import com.fast.word.beans.TableBeans;
import com.fast.word.enums.Document;
import com.fast.word.handller.DefaultTableBeansHandler;
import com.fast.word.handller.ITableBeansHandler;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class WordFile07Writer extends AbstractIBasicWord {

    private final Word07Writer writer = new Word07Writer();

    /**
     * @param title   主标题
     * @param headers 副标题
     */

    @Override
    public void addHeader(String title, String... headers) {
        this.writer.addText(ParagraphAlignment.CENTER, this.defaultHeaderFont, title);
        if (headers.length > 0) {
            this.addParagraphRows(ParagraphAlignment.RIGHT, this.defaultFont, headers);
        }
        List<XWPFParagraph> paragraphs = this.writer.getDoc().getParagraphs();
        XWPFParagraph paragraph = paragraphs.get(0);
        paragraph.removeRun(0);
        XWPFRun xwpfRun = paragraph.createRun();
        xwpfRun.setText(title);
        xwpfRun.setColor("CE0000");   // 设置主标题颜色
        xwpfRun.setFontSize(this.defaultHeaderFont.getSize());
        xwpfRun.setBold(this.defaultHeaderFont.isBold());
        xwpfRun.setFontFamily(this.defaultHeaderFont.getFamily());
        paragraph.addRun(xwpfRun);
        this.addBlankRow();
    }

    /**
     * 自定义添加段落
     *
     * @param alignment   文字方向
     * @param defaultFont 字体
     * @param texts       要添加的文本(独占一行 )
     */
    @Override
    public void addParagraphRows(ParagraphAlignment alignment, Font defaultFont, String... texts) {
        this.defaultFont = defaultFont;
        for (String paragraph : texts) {
            this.writer.addText(alignment, this.defaultFont, paragraph);
        }
    }

    /**
     * 使用默认配置添加文本（文字方向：左 字体：加粗，宋体）
     *
     * @param text 要添加的文本
     */
    @Override
    public void addParagraphRows(String... text) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, text);
        this.addBlankRow();
    }

    /**
     * 添加段落及图片
     *
     * @param picture 图片路径
     * @param texts   文本
     */
    @Override
    public void addParagraphPictureRows(File picture, String... texts) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, texts);
        this.addPicture(picture);
        this.addBlankRow();
    }

    /**
     * 添加图片
     *
     * @param picture 图片路径
     */
    @Override
    public void addPicture(File picture) {
        try {
            this.writer.addPicture(picture, this.defaultWidth, this.defaultHeight);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加图片(输入流)
     *
     * @param stream 图片路径
     */
    @Override
    public void addPicture(InputStream stream, String fileName) {
        try {
            this.writer.addPicture(stream, PicType.PNG, fileName, this.defaultWidth, this.defaultHeight);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义添加图片
     *
     * @param picture       图片路径
     * @param defaultWidth  显示的宽度
     * @param defaultHeight 显示的高度
     */
    @Override
    public void addPicture(File picture, int defaultWidth, int defaultHeight) {
        this.defaultHeight = defaultHeight;
        this.defaultWidth = defaultWidth;
        this.addPicture(picture);
    }

    /**
     * 添加空行
     */
    @Override
    public void addBlankRow() {
        this.writer.addText(ParagraphAlignment.LEFT, this.defaultFont, "");
    }

    /**
     * 使用自定义ITableBeansHandler处理器构建表格
     *
     * @param handler
     */
    @Override
    public void addTable(ITableBeansHandler handler) {
        try {
            this.writer.addTable(handler.createTable());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用table数据bean构建默认数据表格
     *
     * @param tableBeans
     */
    public void addTable(TableBeans tableBeans) {
        try {
            this.addTable(new DefaultTableBeansHandler(tableBeans));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用table数据bean和段落文字构建默认数据表格
     *
     * @param tableBeans
     */
    public void addParagraphTableRows(TableBeans tableBeans, String... texts) {
        try {
            this.addParagraphTableRows(new DefaultTableBeansHandler(tableBeans), texts);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addParagraphTableRows(ITableBeansHandler handler, String... texts) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, texts);
        this.addTable(handler);
        this.addBlankRow();
    }

    @Override
    public String getDocumentFile(String fileName, String savePath) {
        String file = this.getDocumentFile(fileName, savePath, Document.WORD);
        try {
            this.writer.flush(FileUtil.file(file));
            this.writer.close();
            logger.info("==> Preparing: {}", file);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return file;
    }
}
