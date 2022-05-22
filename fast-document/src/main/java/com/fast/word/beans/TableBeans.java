package com.fast.word.beans;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 基础表格beans
 *
 * @author wanghe
 */
public class TableBeans {
    /**
     * 表头
     */
    public List<String> titles;  // [aa,bb,cc]
    /**
     * 数据
     */
    public List<? extends List<?>> dataList;  // 1,2,3
    /**
     * 是否总是显示表头（默认显示，true：只有在dataList数据为空时，showHeader生效）
     */
    public boolean showHeaderOfNoneList = true;

    public TableBeans() {
    }

    /**
     * 直接使用表头及表格数据构建
     *
     * @param titles   表头
     * @param dataList 表格数据
     */
    public TableBeans(List<String> titles, List<? extends List<?>> dataList) {
        this.titles = titles;
        this.dataList = dataList;
    }

    /**
     * 使用map构建（使用map时）注意：
     * <p>1.提取dataList中HashMap所有key作为表头</p>
     * <p>2.提取dataList中HashMap所有value作为表格数据</p>
     *
     * @param dataList 数据
     */
    public TableBeans(List<? extends LinkedHashMap<String, ?>> dataList) {
        if (dataList == null || dataList.size() == 0) {
            throw new RuntimeException("tableList不能为空，本次进程终止....");
        }
        this.titles = dataList.stream().map(bean -> new LinkedList<>(bean.keySet())).collect(Collectors.toList()).get(0);
        this.dataList = dataList.stream().map(bean -> new LinkedList<>(new LinkedList<Object>(bean.values()))).collect(Collectors.toList());
    }

    public List<String> getTitles() {
        return titles;
    }

    public TableBeans setTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }

    public List<? extends List<?>> getDataList() {
        return dataList;
    }

    public TableBeans setDataList(List<? extends List<?>> dataList) {
        this.dataList = dataList;
        return this;
    }

    public boolean isShowHeaderOfNoneList() {
        return showHeaderOfNoneList;
    }

    public TableBeans setShowHeaderOfNoneList(boolean showHeaderOfNoneList) {
        this.showHeaderOfNoneList = showHeaderOfNoneList;
        return this;
    }
}
