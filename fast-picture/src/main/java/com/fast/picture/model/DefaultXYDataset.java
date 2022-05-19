package com.fast.picture.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 默认绘图数据集对象
 * <p>
 * 涉及到x，y轴坐标数据
 *
 * @author wanghe
 */
public class DefaultXYDataset extends BasicDataset {
    /**
     * x坐标数据
     */
    public List<List<Object>> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    public List<String> XAxisLabelList;

    public DefaultXYDataset() {
    }

    public DefaultXYDataset(List<String> legendNames, List<List<Object>> YAxisLabelList, List<String> XAxisLabelList) {
        this.legendNames = legendNames;
        this.XAxisLabelList = XAxisLabelList;
        this.YAxisLabelList = YAxisLabelList;
    }

    public DefaultXYDataset(String legendName, List<Object> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendName);
        this.YAxisLabelList = Arrays.asList(YAxisLabelList);
        this.XAxisLabelList = XAxisLabelList;
    }

    public List<List<Object>> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultXYDataset setYAxisLabelList(List<List<Object>> YAxisLabelList) {
        this.YAxisLabelList = YAxisLabelList;
        return this;
    }

    public List<String> getXAxisLabelList() {
        return XAxisLabelList;
    }

    public DefaultXYDataset setXAxisLabelList(List<String> XAxisLabelList) {
        this.XAxisLabelList = XAxisLabelList;
        return this;
    }
}
