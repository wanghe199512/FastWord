package com.fast.word.handller;

import com.fast.word.beans.TableBeans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractDefaultTableBeansHandler implements ITableBeansHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 表格数据实体
     */
    protected TableBeans tableBeans = null;

    public AbstractDefaultTableBeansHandler(TableBeans tableBeans) {
        this.tableBeans = tableBeans;
    }

    @Override
    public List<Map<String, Object>> drawTable() {
        if (this.tableBeans == null) {
            throw new RuntimeException("请先初始化tableBeans ...");
        }
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < this.tableBeans.getColumnList().size(); i++) {
            resultList.add(this.getTableHandler(i));
        }
        return resultList;
    }

    public TableBeans getTableBeans() {
        return tableBeans;
    }

    public abstract Map<String, Object> getTableHandler(int index) throws IndexOutOfBoundsException;
}
