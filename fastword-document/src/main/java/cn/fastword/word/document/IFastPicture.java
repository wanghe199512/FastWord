package cn.fastword.word.document;

import java.io.File;
import java.io.InputStream;

public interface IFastPicture {

    void addPicture(File picture);

    void addPicture(InputStream stream, String fileName);

    void addPicture(File picture, int defaultWidth, int defaultHeight);
}
