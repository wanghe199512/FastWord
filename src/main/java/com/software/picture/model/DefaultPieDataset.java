package com.software.picture.model;

import java.util.List;

/**
 * 默认绘图数据集对象
 *
 * @author wanghe
 */
public class DefaultPieDataset extends BasicDataset {
    /**
     * x坐标数据
     */
    public List<?> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    public List<String> XAxisLabelList;

    public DefaultPieDataset() {
    }

    public DefaultPieDataset(String dataSetName) {
        super(dataSetName);
    }

    public DefaultPieDataset(String dataSetName, List<?> YAxisLabelList, List<String> XAxisLabelList) {
        this.dataSetName = dataSetName;
        this.YAxisLabelList = YAxisLabelList;
        this.XAxisLabelList = XAxisLabelList;
    }

    public List<?> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultPieDataset setYAxisLabelList(List<?> YAxisLabelList) {
        this.YAxisLabelList = YAxisLabelList;
        return this;
    }

    public List<String> getXAxisLabelList() {
        return XAxisLabelList;
    }

    public DefaultPieDataset setXAxisLabelList(List<String> XAxisLabelList) {
        this.XAxisLabelList = XAxisLabelList;
        return this;
    }
}
