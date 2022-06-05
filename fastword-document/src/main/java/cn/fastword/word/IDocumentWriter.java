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

    <A, B> void addParagraphRows(A alignment, B defaultFont, String... texts);

    void addParagraphRows(String... text);

    void addParagraphPictureRows(File picture, String... texts);

    void addPicture(File picture);

    void addPicture(InputStream stream, String fileName);

    void addPicture(File picture, int defaultWidth, int defaultHeight);

    void addBlankRow();
}
