package com.fast.picture.model;

import com.fast.picture.model.builder.CreatorBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
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
    private List<? extends LinkedList<? extends Number>> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    private List<String> XAxisLabelList;

    public DefaultXYDataset() {
    }

    public DefaultXYDataset(String legendName, LinkedList<? extends Number> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendName);
        this.YAxisLabelList = Collections.singletonList(YAxisLabelList);
        this.XAxisLabelList = XAxisLabelList;
    }

    public DefaultXYDataset(String[] legendNames, List<? extends LinkedList<? extends Number>> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendNames);
        this.XAxisLabelList = XAxisLabelList;
        this.YAxisLabelList = YAxisLabelList;
    }

    public DefaultXYDataset(String[] legendNames, LinkedList<Collection<String>> YAxisLabelList, List<String> XAxisLabelList) {
        this(legendNames, CreatorBuilder.singletonYAxisList(YAxisLabelList), XAxisLabelList);
    }

    public List getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultXYDataset setYAxisLabelList(List<LinkedList<? extends Number>> YAxisLabelList) {
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
