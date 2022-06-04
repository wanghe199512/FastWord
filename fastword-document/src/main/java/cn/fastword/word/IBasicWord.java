package cn.fastword.word;

import cn.fastword.word.enums.FastDocument;

import java.io.File;

/**
 * 报告基础获取接口
 *
 * @author 王贺
 */
public interface IBasicWord {

    File getDocumentFile(String fileName, String savePath, FastDocument document);
}
