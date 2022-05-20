package com.fast.picture.model;

import java.util.Collections;
import java.util.List;

/**
 * 默认绘图数据集对象
 * <p>
 * 适用范围：涉及到x，y轴坐标数据
 * </p>
 *
 * @author wanghe
 */
public class DefaultXYDataset extends BasicDataset {
    /**
     * x坐标数据
     */
    public List<List<? extends Number>> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    public List<String> XAxisLabelList;

    public DefaultXYDataset() {
    }

    public DefaultXYDataset(List<String> legendNames, List<List<? extends Number>> YAxisLabelList, List<String> XAxisLabelList) {
        this.legendNames = legendNames;
        this.XAxisLabelList = XAxisLabelList;
        this.YAxisLabelList = YAxisLabelList;
    }

    /**
     * 默认构造
     *
     * @param legendName     图例名称
     * @param YAxisLabelList 纵轴数据
     * @param XAxisLabelList 横轴数据
     */
    public DefaultXYDataset(String legendName, List<? extends Number> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendName);
        this.YAxisLabelList = Collections.singletonList(YAxisLabelList);
        this.XAxisLabelList = XAxisLabelList;
    }

    public List<List<? extends Number>> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultXYDataset setYAxisLabelList(List<List<? extends Number>> YAxisLabelList) {
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
