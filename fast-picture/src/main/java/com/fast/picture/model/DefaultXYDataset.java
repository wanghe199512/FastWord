package com.fast.picture.model;

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
    public List<List<Number>> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    public List<String> XAxisLabelList;

    public DefaultXYDataset() {
    }

    public DefaultXYDataset(String legendName) {
        super(legendName);
    }

    public DefaultXYDataset(List<String> legendNames, List<List<Number>> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendNames);
        this.YAxisLabelList = YAxisLabelList;
        this.XAxisLabelList = XAxisLabelList;
    }

    public DefaultXYDataset(String legendName, List<Number> YAxisLabelList, List<String> XAxisLabelList) {
        this(legendName);
        this.YAxisLabelList = Arrays.asList(YAxisLabelList);
        this.XAxisLabelList = XAxisLabelList;
    }

    public List<List<Number>> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultXYDataset setYAxisLabelList(List<List<Number>> YAxisLabelList) {
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
