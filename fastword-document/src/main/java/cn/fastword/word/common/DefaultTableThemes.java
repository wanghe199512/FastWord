package cn.fastword.word.common;


import java.io.Serializable;
import java.util.Arrays;

/**
 * FastWord默认表格属性bean
 *
 * @author wanghe
 */
public class DefaultTableThemes implements Serializable {
    //列宽
    private int cellWidth = 0;
    // 表格宽度
    private int tableWidth = 2000;
    // 边距
    private int[] margin = {50, 50, 50, 50};
    // 是否显示斑马线
    private boolean showZebra = true;
    // 斑马线颜色
    private String[] zebraColor = {BaseFontColor.LIGHT_BLUE, BaseFontColor.DARK_BLUE};
    // 行高
    private int rowHeight = 30;
    // 表格首行标题是否加粗
    private boolean headerBold = true;

    public DefaultTableThemes() {
    }

    public DefaultTableThemes(int[] margin, String[] zebraColor) {
        if (zebraColor.length != 2) {
            throw new RuntimeException("zebraColor lengths can only be 2. example: ['EDF2F8','D3DFEE']");
        }
        this.zebraColor = zebraColor;
        if (margin.length != 4) {
            throw new RuntimeException("margin lengths can only be 4. example: [top,left,bottom,right]");
        }
        this.margin = margin;
    }

    public DefaultTableThemes(int width, int cellWidth, int[] margin, boolean showZebra, String[] zebraColor, int rowHeight, boolean headerBold) {
        this(margin, zebraColor);
        this.tableWidth = width;
        this.cellWidth = cellWidth;
        this.showZebra = showZebra;
        this.rowHeight = rowHeight;
        this.headerBold = headerBold;
    }

    public int getTableWidth() {
        return tableWidth;
    }

    public DefaultTableThemes setTableWidth(int tableWidth) {
        this.tableWidth = tableWidth;
        return this;
    }

    public int[] getMargin() {
        return margin;
    }

    public DefaultTableThemes setMargin(int[] margin) {
        this.margin = margin;
        return this;
    }

    public boolean isShowZebra() {
        return showZebra;
    }

    public DefaultTableThemes setShowZebra(boolean showZebra) {
        this.showZebra = showZebra;
        return this;
    }

    public String[] getZebraColor() {
        return zebraColor;
    }

    public DefaultTableThemes setZebraColor(String[] zebraColor) {
        this.zebraColor = zebraColor;
        return this;
    }

    public int getRowHeight() {
        return rowHeight;
    }

    public DefaultTableThemes setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
        return this;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public DefaultTableThemes setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
        return this;
    }

    public boolean isHeaderBold() {
        return headerBold;
    }

    public DefaultTableThemes setHeaderBold(boolean headerBold) {
        this.headerBold = headerBold;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "cellWidth:" + cellWidth +
                ", tableWidth:" + tableWidth +
                ", margin:" + Arrays.toString(margin) +
                ", showZebra:" + showZebra +
                ", zebraColor:" + Arrays.toString(zebraColor) +
                ", rowHeight：" + rowHeight +
                ", hfBold：" + headerBold +
                '}';
    }
}