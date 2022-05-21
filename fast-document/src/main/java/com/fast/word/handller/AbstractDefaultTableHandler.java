package com.fast.word.handller;

import com.fast.word.beans.TableBeans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractDefaultTableHandler implements ITableBeansHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 表格数据实体
     */
    protected TableBeans tableBeans = null;

    protected AbstractDefaultTableHandler() {
    }

    protected AbstractDefaultTableHandler(TableBeans tableBeans) {
        this.tableBeans = tableBeans;
    }

    @Override
    public List<Map<String, Object>> createTable() {
        if (this.tableBeans == null) {
            throw new RuntimeException("请先初始化tableBeans ...");
        }
        List<Map<String, Object>> resultList = new ArrayList<>();
        if (this.tableBeans.dataList.size() > 0) {
            for (int i = 0; i < this.tableBeans.getDataList().size(); i++) {
                resultList.add(this.createTableHandler(i));
            }
        }
        if (this.tableBeans.dataList.size() == 0 && this.tableBeans.showHeaderOfNoneList) {   // 只有在dataList数据为空时，showHeader生效
            resultList.add(this.createNullTable()); // 当数据为空时，也显示表头
        }
        return resultList;
    }

    public TableBeans getTableBeans() {
        return tableBeans;
    }

    /**
     * 当数据为空时，是否绘制表头显示
     */
    private Map<String, Object> createNullTable() {
        Map<String, Object> result = new LinkedHashMap<>();
        for (String title : this.tableBeans.getTitles()) {
            result.put(title, "");
        }
        return result;
    }

    public abstract Map<String, Object> createTableHandler(int index) throws IndexOutOfBoundsException;
}
