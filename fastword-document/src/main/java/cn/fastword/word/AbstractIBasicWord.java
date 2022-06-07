package cn.fastword.word;

import cn.fastword.word.common.Constants;
import cn.fastword.word.enums.FastArchive;
import cn.fastword.word.enums.FastDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
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

    /**
     * 默认子目录生成路径
     */
    protected final String filePath = "已生成报告";
    /**
     * 归档类型(默认，按天)
     */
    protected FastArchive archive = FastArchive.DAY;

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

    protected abstract File saveWordFile(File file);

    public File getDocumentFile(File file) throws IOException {
        return this.saveWordFile(file);
    }

    @Override
    public File getDocumentFile(String fileName, String savePath, FastDocument document) {
        return new File(savePath.concat(File.separator).concat(filePath).concat(File.separator).concat(document.getName()).concat(File.separator).concat(this.archive.archive()).concat(File.separator)
                .concat(fileName).concat(Objects.requireNonNull(FastDocument.getDocumentPix(document))));
    }

    protected File createNewFile(File file) throws IOException {
        if (file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    public AbstractIBasicWord setArchive(FastArchive archive) {
        this.archive = archive;
        return this;
    }
}
