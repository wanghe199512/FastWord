package cn.fastword.picture.model;

import java.util.UUID;

/**
 * 基础
 */
public class Picture {
    /**
     * 图片标题
     */
    private String[] title;

    /**
     * 图片宽度
     */
    private int defaultWidth = 1300;
    /**
     * 图片高度
     */
    private int defaultHeight = 500;
    /**
     * 图片名称
     */
    private String fileName;

    public Picture() {
        this(UUID.randomUUID().toString());
    }

    public Picture(String fileName, String... title) {
        if (title.length > 2) {
            throw new RuntimeException("仅可设置主标题、子标题，title长度超出...");
        }
        this.fileName = fileName;
    }

    public Picture(String fileName, int defaultWidth, int defaultHeight) {
        this(fileName);
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

    public String[] getTitle() {
        return title;
    }

    public Picture setTitle(String[] title) {
        this.title = title;
        return this;
    }
}
