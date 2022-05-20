package com.fast.picture.model;

import java.util.Collections;
import java.util.List;

/**
 * 默认绘图数据集对象
 * <p>
 * 适用范围：涉及到x，y轴坐标数据
 * </p>
 * <p>
 * 默认构造:DefaultXYDataset(String legendName, List<? extends Number> YAxisLabelList, List<String> XAxisLabelList)
 * 支持图例一对多数据的使用
 * </p>
 * <p>
 * 增强构造：List<String> legendNames, List<List<? extends Number>> YAxisLabelList, List<String> XAxisLabelList
 * 支持多对多使用
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
