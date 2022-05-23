package com.fast.word.beans;

import com.fast.word.handller.DefaultAnnotationTableHandler;

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
    private List<String> titles;  // [aa,bb,cc]
    /**
     * 数据
     */
    private List<? extends List<?>> dataList;  // 1,2,3
    /**
     * 是否总是显示表头（默认显示，true：只有在dataList数据为空时，showHeader生效）
     */
    private boolean showHeaderOfNoneList = true;

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
