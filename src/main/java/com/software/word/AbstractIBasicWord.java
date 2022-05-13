package com.software.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.word.Word07Writer;
import com.software.word.handller.ITableBeansHandler;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.util.UUID;

/**
 * 基础word
 * 抽象说明：
 *
 * @author wanghe
 * @link addParagraphPictureRows, addParagraphTableRows 组合使用时，在word中表现形式为各输出独占一行，且文字优先排列
 */
public abstract class AbstractIBasicWord implements IBasicWord {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 文件名称  如果没有名称将使用默认UUID作为文件名称,此时word中标题也为此标题
     */
    protected String fileName = UUID.randomUUID().toString();
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

    public AbstractIBasicWord(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 子标题段落（主标题与文件名称fileName相同）
     */
    protected void addHeader(String... headers) {
        this.writer.addText(ParagraphAlignment.CENTER, this.defaultHeaderFont, this.fileName);
        this.addParagraphRows(ParagraphAlignment.RIGHT, this.defaultFont, headers);
        this.addBlankRow();
    }

    protected void addParagraphRows(ParagraphAlignment alignment, Font defaultFont, String... texts) {
        this.defaultFont = defaultFont;
        for (String paragraph : texts) {
            this.writer.addText(alignment, this.defaultFont, paragraph);
        }
    }

    protected void addParagraphRows(String... text) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, text);
        this.addBlankRow();
    }

    protected void addParagraphPictureRows(File picture, String... texts) {
        this.addParagraphRows(ParagraphAlignment.LEFT, this.defaultFont, texts);
        this.addPicture(picture);
        this.addBlankRow();
    }

    public void addPicture(File picture) {
        try {
            this.writer.addPicture(picture, this.defaultWidth, this.defaultHeight);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    protected void addPicture(File picture, int defaultWidth, int defaultHeight) {
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
        } catch (Exception e) {
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
    public void getWord2007(String savePath) {
        try {
            String fileName = savePath.concat(File.separator).concat("已生成报告").concat(File.separator)
                    .concat(this.fileName).concat(".docx");
            this.reportWriter();
            this.writer.flush(FileUtil.file(fileName));
            this.writer.close();
            logger.info("==> Preparing: {}", fileName);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
