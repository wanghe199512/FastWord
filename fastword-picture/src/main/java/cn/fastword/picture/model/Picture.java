package cn.fastword.picture.model;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 基础
 */
public class Picture {

    private List<String> title;
    /**
     * 图片宽度
     */
    private int defaultWidth;
    /**
     * 图片高度
     */
    private int defaultHeight;
    /**
     * 图片名称
     */
    private String fileName;

    public Picture(String fileName, String... title) {
        this(fileName, 1300, 500, title);
    }

    public Picture(String fileName, int defaultWidth, int defaultHeight, String... title) {
        if (title.length > 2) {
            throw new RuntimeException("仅可设置主标题、子标题，title长度超出...");
        }
        this.fileName = fileName;
        this.title = Arrays.asList(title);
        this.defaultHeight = defaultHeight;
        this.defaultWidth = defaultWidth;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public Picture setDefaultWidth(int defaultWidth) {
        this.defaultWidth = defaultWidth;
        return this;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }

    public Picture setDefaultHeight(int defaultHeight) {
        this.defaultHeight = defaultHeight;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public Picture setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public List<String> getTitle() {
        return title;
    }

    public Picture setTitle(List<String> title) {
        this.title = title;
        return this;
    }
}
