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
    public List<List<Object>> dataList;  // 1,2,3
    /**
     * 是否总是显示表头（默认显示，false：只有在dataList数据为空时，showHeader生效）
     */
    public boolean showHeaderOfNoneList = true;

    public TableBeans() {
    }

    public TableBeans(List<String> titles, List<List<Object>> dataList) {
        this.titles = titles;
        this.dataList = dataList;
    }

    public TableBeans(String[] titles, List<LinkedHashMap<String, String>> tableList) {
        if (tableList == null || tableList.size() == 0) {
            throw new RuntimeException("tableList不能为空，本次进程终止....");
        }
        this.titles = Arrays.asList(titles);
        this.dataList = tableList.stream().map(bean -> new ArrayList<>(new LinkedList<Object>(bean.values()))).collect(Collectors.toList());
    }

    public List<String> getTitles() {
        return titles;
    }

    public TableBeans setTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }

    public List<List<Object>> getDataList() {
        return dataList;
    }

    public TableBeans setDataList(List<List<Object>> dataList) {
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
