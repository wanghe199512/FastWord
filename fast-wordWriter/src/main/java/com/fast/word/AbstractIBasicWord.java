package com.fast.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.word.Word07Writer;
import com.fast.word.handller.ITableBeansHandler;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.List;
import java.io.File;

/**
 * 基础word
 * 抽象说明：
 *
 * @author wanghe
 * addParagraphPictureRows, addParagraphTableRows 组合使用时，在word中表现形式为各输出独占一行，且文字优先排列
 */
public abstract class AbstractIBasicWord implements IBasicWord {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 全局字体
     */
    protected final String fontName = "宋体";
    /**
     * 默认正文字体
     */
    protected Font defaultFont = new Font(this.fontName, Font.BOLD, 12);
    /**
     * 默认标题头字体
     */
    protected Font defaultHeaderFont = new Font(this.fontName, Font.BOLD, 30);
    /**
     * 图片宽度
     */
    private int defaultWidth = 450;
    /**
     * 图片高度
     */
    private int defaultHeight = 130;

    private final Word07Writer writer = new Word07Writer();

    public AbstractIBasicWord() {

    }

    /**
     * @param title   主标题
     * @param headers 副标题
     */
    protected void addHeader(String title, String... headers) {
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
    protected void addParagraphRows(ParagraphAlignment alignment, Font defaultFont, String... texts) {
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
    protected void addParagraphRows(String... text) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, text);
        this.addBlankRow();
    }

    /**
     * 添加段落及图片
     *
     * @param picture 图片路径
     * @param texts   文本
     */
    protected void addParagraphPictureRows(File picture, String... texts) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, texts);
        this.addPicture(picture);
        this.addBlankRow();
    }

    /**
     * 添加图片
     *
     * @param picture 图片路径
     */
    public void addPicture(File picture) {
        try {
            this.writer.addPicture(picture, this.defaultWidth, this.defaultHeight);
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
    protected void addPicture(File picture, int defaultWidth, int defaultHeight){
        this.defaultHeight = defaultHeight;
        this.defaultWidth = defaultWidth;
        this.addPicture(picture);
    }

    /**
     * 添加空行
     */
    protected void addBlankRow() {
        this.writer.addText(ParagraphAlignment.LEFT, this.defaultFont, "");
    }

    protected void addTable(ITableBeansHandler handler) {
        try {
            this.writer.addTable(handler.drawTable());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    protected void addParagraphTableRows(ITableBeansHandler handler, String... texts) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, texts);
        this.addTable(handler);
        this.addBlankRow();
    }

    public abstract void reportWriter();

    @Override
    public String getWord2007(String fileName, String savePath) {
        String file = savePath.concat(File.separator).concat("已生成报告").concat(File.separator).concat(fileName).concat(".docx");
        try {
            this.reportWriter();
            this.writer.flush(FileUtil.file(file));
            this.writer.close();
            logger.info("==> Preparing: {}", file);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return file;
    }
}
