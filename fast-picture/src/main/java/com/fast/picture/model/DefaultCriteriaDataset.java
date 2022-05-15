package com.fast.picture.model;

/**
 * 默认绘图数据集对象
 *
 * @author wanghe
 */
public class DefaultCriteriaDataset extends BasicDataset {
    /**
     * 数值
     */
    public Number value;

    public DefaultCriteriaDataset() {
    }

    public DefaultCriteriaDataset(String dataSetName, Number value) {
        super(dataSetName);
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public DefaultCriteriaDataset setValue(Number value) {
        this.value = value;
        return this;
    }
}
