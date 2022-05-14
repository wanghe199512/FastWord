package com.fast.picture.model;

public class BasicDataset {
    /**
     * 数据集名称
     */
    public String dataSetName;

    public BasicDataset() {
    }

    public BasicDataset(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public BasicDataset setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
        return this;
    }
}
