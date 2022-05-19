package com.fast.picture.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
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
        this.legendNames = Arrays.asList(legendName);
    }

    public List<String> getLegendNames() {
        return legendNames;
    }

    public BasicDataset setLegendNames(List<String> legendNames) {
        this.legendNames = legendNames;
        return this;
    }
}
