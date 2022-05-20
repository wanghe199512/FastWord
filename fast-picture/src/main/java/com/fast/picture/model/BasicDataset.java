package com.fast.picture.model;

import java.util.Collections;
import java.util.List;

public class BasicDataset {
    /**
     * 数据集名称
     */
    public List<String> legendNames;

    public BasicDataset() {
    }

    public BasicDataset(List<String> legendNames) {
        this.legendNames = legendNames;
    }

    public BasicDataset(String legendName) {
        this.legendNames = Collections.singletonList(legendName);
    }

    public List<String> getLegendNames() {
        return legendNames;
    }

    public BasicDataset setLegendNames(List<String> legendNames) {
        this.legendNames = legendNames;
        return this;
    }
}
