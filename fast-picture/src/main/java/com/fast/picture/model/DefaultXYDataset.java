package com.fast.picture.model;

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
    public List<?> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    public List<String> XAxisLabelList;

    public DefaultXYDataset() {
    }

    public DefaultXYDataset(String dataSetName) {
        super(dataSetName);
    }

    public DefaultXYDataset(String dataSetName, List<?> YAxisLabelList, List<String> XAxisLabelList) {
        this.dataSetName = dataSetName;
        this.YAxisLabelList = YAxisLabelList;
        this.XAxisLabelList = XAxisLabelList;
    }

    public List<?> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultXYDataset setYAxisLabelList(List<?> YAxisLabelList) {
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
