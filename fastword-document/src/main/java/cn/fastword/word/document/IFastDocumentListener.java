package cn.fastword.word.document;

import cn.fastword.word.enums.FastDocument;

import java.io.File;

public interface IFastDocumentListener<T> extends IFastParagraph, IFastTable<T>, IFastPicture,IFastEventListener{

    File getDocumentFile(String fileName, String savePath, FastDocument document);
}
