package com.fast.picture.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicDataset {
    /**
     * 数据集名称
     */
    public List<String> legendNames;

    public BasicDataset() {
    }

    public BasicDataset(String[] legendNames) {
        this.legendNames = Stream.of(legendNames).collect(Collectors.toList());
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
