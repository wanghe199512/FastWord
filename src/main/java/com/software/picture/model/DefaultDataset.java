package com.software.picture.model;

import java.util.List;

/**
 * 默认绘图数据集对象
 *
 * @author wanghe
 */
public class DefaultDataset extends BasicDataset {
    /**
     * x坐标数据
     */
    public List<?> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    public List<String> XAxisLabelList;

    public DefaultDataset() {
    }

    public DefaultDataset(String dataSetName) {
        super(dataSetName);
    }

    public DefaultDataset(String dataSetName, List<?> YAxisLabelList, List<String> XAxisLabelList) {
        this.dataSetName = dataSetName;
        this.YAxisLabelList = YAxisLabelList;
        this.XAxisLabelList = XAxisLabelList;
    }

    public List<?> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultDataset setYAxisLabelList(List<?> YAxisLabelList) {
        this.YAxisLabelList = YAxisLabelList;
        return this;
    }

    public List<String> getXAxisLabelList() {
        return XAxisLabelList;
    }

    public DefaultDataset setXAxisLabelList(List<String> XAxisLabelList) {
        this.XAxisLabelList = XAxisLabelList;
        return this;
    }
}
