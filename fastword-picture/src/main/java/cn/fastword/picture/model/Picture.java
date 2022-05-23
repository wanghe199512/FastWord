package cn.fastword.picture.model;

/**
 * 基础
 */
public class Picture {
    /**
     * 生成图片宽度
     */
    public int defaultWidth = 1300;
    /**
     * 生成图片高度
     */
    public int defaultHeight = 500;
    /**
     * 生成图片名称
     */
    public String fileName;


    public Picture() {
    }

    public Picture(String fileName) {
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
}
