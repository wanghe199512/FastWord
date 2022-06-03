package cn.fastword.word;

import cn.fastword.word.handller.ITableBeans;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import java.awt.*;
import java.io.File;
import java.io.InputStream;

/**
 * 文档实现能力清单
 *
 * @author wanghe
 */
public interface IDocumentWriter<E> {

    void addHeader(String title, String... headers);

    void addParagraphRows(E alignment, Font defaultFont, String... texts);

    void addParagraphRows(String... text);

    void addParagraphPictureRows(File picture, String... texts);

    void addPicture(File picture);

    void addPicture(InputStream stream, String fileName);

    void addPicture(File picture, int defaultWidth, int defaultHeight);

    void addBlankRow();

    void addTable(ITableBeans<?> handler);

    void addParagraphTableRows(ITableBeans<?> handler, String... texts);
}
