package com.fast.word.beans;

import java.util.List;

/**
 * 基础表格beans
 *
 * @author wanghe
 */
public class TableBeans {


    public List<String> titleColumn;  // [aa,bb,cc]

    public List<List<String>> columnList;  // 1,2,3

    public TableBeans() {

    }

    public TableBeans(List<String> titleColumn, List<List<String>> valueColumn) {
        this.titleColumn = titleColumn;
        this.columnList = valueColumn;
    }

    public List<String> getTitleColumn() {
        return titleColumn;
    }

    public TableBeans setTitleColumn(List<String> titleColumn) {
        this.titleColumn = titleColumn;
        return this;
    }

    public List<List<String>> getColumnList() {
        return columnList;
    }

    public TableBeans setColumnList(List<List<String>> columnList) {
        this.columnList = columnList;
        return this;
    }
}
