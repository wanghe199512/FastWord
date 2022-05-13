package com.software.core.batch;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.ZipUtil;
import com.software.word.IBasicWord;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.util.Collection;

/**
 * 批量word生成执行器
 *
 * @author wanghe
 */
public class Word07BatchExecutor {
    /**
     * 保存路径
     */
    private String savePath;

    private Collection<? extends IBasicWord> basicWords;

    public Word07BatchExecutor(Collection<? extends IBasicWord> basicWords, String savePath) {
        this.basicWords = basicWords;
        this.savePath = savePath;
    }

    public Word07BatchExecutor exec() {
        if (CollectionUtils.isEmpty(this.basicWords)) {
            throw new RuntimeException("[错误] 执行的文档对象列表为空,本次进程终止.....");
        }
        for (IBasicWord basicWord : this.basicWords) {
            basicWord.getWord2007(this.savePath);
        }
        return this;
    }

    /**
     * 是否启用压缩
     *
     * @return 压缩文件路径
     */
    public File isWinRar(boolean compress) throws UtilException {
        File file = null;
        if (compress) {
            file = ZipUtil.zip(this.savePath, new File(this.savePath).getParent());
        }
        return file;
    }


}
