package cn.fastword.word.common;

public class BaseFont {
    /**
     * 字体类型
     */
    public String family = "宋体";
    /**
     * 字体大小
     */
    public int size = 18;
    /**
     * 字体颜色
     */
    public String color = BaseFontColor.BLANK;
    /**
     * 是否加粗
     */
    public boolean bold = false;

    /**
     * 获取指定大小
     *
     * @param size  字体大小
     * @param color 字体颜色
     * @return BaseFont
     */
    public static BaseFont specifies(int size, String color, boolean bold) {
        return new BaseFont(size, color, bold);
    }

    /**
     * 获取小字体
     *
     * @return BaseFont
     */
    public static BaseFont small() {
        return new BaseFont(14, BaseFontColor.BLANK, false);
    }

    /**
     * 获取中等字体
     *
     * @return BaseFont
     */
    public static BaseFont middle() {
        return new BaseFont(20, BaseFontColor.BLANK, false);
    }

    /**
     * 获取大字体
     *
     * @return BaseFont
     */
    public static BaseFont large() {
        return new BaseFont(35, BaseFontColor.BLANK, false);
    }


    public BaseFont(String family, int size, String color, boolean isBold) {
        this(size, color, isBold);
        this.family = family;
    }

    public BaseFont(String family) {
        this.family = family;
    }

    public BaseFont(int size, String color, boolean bold) {
        this.size = size;
        this.color = color;
        this.bold = bold;
    }
}
