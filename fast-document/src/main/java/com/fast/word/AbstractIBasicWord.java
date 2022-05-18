package com.fast.word;

import com.fast.word.enums.Documents;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.InputStream;

/**
 * 基础word
 * 抽象说明：
 *
 * @author wanghe
 * addParagraphPictureRows, addParagraphTableRows 组合使用时，在word中表现形式为各输出独占一行，且文字优先排列
 */
public abstract class AbstractIBasicWord implements IBasicWord, IDocumentWriter {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
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
    protected final Font defaultHeaderFont = new Font(this.fontName, Font.BOLD, 30);
    /**
     * 图片宽度
     */
    protected int defaultWidth = 450;
    /**
     * 图片高度
     */
    protected int defaultHeight = 130;

    public AbstractIBasicWord() {
    }

    public abstract void addHeader(String title, String... headers);

    public abstract void addParagraphRows(ParagraphAlignment alignment, Font defaultFont, String... texts);

    public abstract void addParagraphRows(String... text);

    public abstract void addParagraphPictureRows(File picture, String... texts);

    public abstract void addPicture(File picture);

    public abstract void addPicture(InputStream stream, String fileName);

    public abstract void addPicture(File picture, int defaultWidth, int defaultHeight);

    public abstract void addBlankRow();

    protected String getDocumentFile(String fileName, String savePath, Documents document) {
        return savePath.concat(File.separator).concat("已生成报告").concat(File.separator).concat(document.getName())
                .concat(File.separator).concat(fileName).concat(document.getName().equals("Word文档") ? ".docx" : ".pdf");
    }
}
