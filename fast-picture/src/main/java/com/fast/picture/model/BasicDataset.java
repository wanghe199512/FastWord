package com.fast.picture.model;

public class BasicDataset {
    /**
     * 数据集名称
     */
    public String legendName;

    public BasicDataset() {
    }

    public BasicDataset(String legendName) {
        this.legendName = legendName;
    }

    public String getLegendName() {
        return legendName;
    }

    public BasicDataset setLegendName(String legendName) {
        this.legendName = legendName;
        return this;
    }
}
