package com.fast.word;

import com.fast.word.handller.ITableBeans;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import java.awt.*;
import java.io.File;
import java.io.InputStream;

/**
 * 文档实现能力清单（后续其他格式文档均继承）
 *
 * @author wanghe
 */
public interface IDocumentWriter {

    public void addHeader(String title, String... headers);

    public void addParagraphRows(ParagraphAlignment alignment, Font defaultFont, String... texts);

    public void addParagraphRows(String... text);

    public void addParagraphPictureRows(File picture, String... texts);

    public void addPicture(File picture);

    public void addPicture(InputStream stream, String fileName);

    public void addPicture(File picture, int defaultWidth, int defaultHeight);

    public void addBlankRow();

    public void addTable(ITableBeans handler);

    public void addParagraphTableRows(ITableBeans handler, String... texts);
}
