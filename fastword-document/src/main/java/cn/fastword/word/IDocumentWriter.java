package cn.fastword.word;

import java.io.File;
import java.io.InputStream;

/**
 * 文档实现能力清单
 *
 * @author wanghe
 */
public interface IDocumentWriter {

    void addHeader(String title, String... headers);

    void addParagraphRows(String... text);

    void addParagraphPictureRows(File picture, String... texts);

    void addPicture(File picture);

    void addPicture(InputStream stream, String fileName);

    void addPicture(File picture, int defaultWidth, int defaultHeight);

    void addBlankRow();
}
