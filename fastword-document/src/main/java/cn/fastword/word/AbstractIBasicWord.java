package cn.fastword.word;

import cn.fastword.word.common.Constants;
import cn.fastword.word.enums.FastDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;

/**
 * 基础word
 * 抽象说明：
 *
 * @author wanghe
 * addParagraphPictureRows, addParagraphTableRows 组合使用时，在word中表现形式为各输出独占一行，且文字优先排列
 */
public abstract class AbstractIBasicWord extends Constants implements IBasicWord, IDocumentWriter {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @Override
    public abstract void addHeader(String title, String... headers);

    @Override
    public abstract <A, B> void addParagraphRows(A alignment, B defaultFont, String... texts);

    @Override
    public abstract void addParagraphRows(String... text);

    @Override
    public abstract void addParagraphPictureRows(File picture, String... texts);

    @Override
    public abstract void addPicture(File picture);

    @Override
    public abstract void addPicture(InputStream stream, String fileName);

    @Override
    public abstract void addPicture(File picture, int defaultWidth, int defaultHeight);

    @Override
    public abstract void addBlankRow();

    protected File getDocumentFile(File file) {
        return this.getDocumentFile(file.getName(), file.getParentFile().getAbsolutePath());
    }

    protected File getDocumentFile(String fileName, String savePath) {
        return new File(savePath, fileName);
    }

    @Override
    public File getDocumentFile(String fileName, String savePath, FastDocument document) {
        return this.getDocumentFile(savePath.concat(File.separator).concat("已生成报告").concat(File.separator).concat(document.getName()).concat(File.separator),
                fileName.concat(Objects.requireNonNull(FastDocument.getDocumentPix(document))));
    }

    ;
}
