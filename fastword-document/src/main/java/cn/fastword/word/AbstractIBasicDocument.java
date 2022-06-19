package cn.fastword.word;

import cn.fastword.word.annotation.IFastWordTabledAdapter;
import cn.fastword.word.common.BaseFont;
import cn.fastword.word.common.DefaultTableThemes;
import cn.fastword.word.enums.FastArchive;
import cn.fastword.word.enums.FastDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 基础word
 * 抽象说明：
 *
 * @author wanghe
 * addParagraphPictureRows, addParagraphTableRows 组合使用时，在word中表现形式为各输出独占一行，且文字优先排列
 */
public abstract class AbstractIBasicDocument extends IFastWordTabledAdapter implements IBasicWord {
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
    /**
     * 字体
     */
    protected BaseFont baseFont = new BaseFont("宋体");

    public AbstractIBasicDocument() {
        super();
    }

    public AbstractIBasicDocument(DefaultTableThemes themes) {
        super(themes);
    }

    public AbstractIBasicDocument(Class<?> beanCls) {
        super(beanCls);
    }

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
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    public AbstractIBasicDocument setArchive(FastArchive archive) {
        this.archive = archive;
        return this;
    }
}
