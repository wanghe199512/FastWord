package com.fast.word.handller;

import com.fast.word.beans.TableBeans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象表格处理器
 *
 * @author wanghe
 */
public abstract class AbstractTableHandler implements ITableBeans {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 表格数据实体
     */
    protected TableBeans tableBeans = null;

    protected AbstractTableHandler() {
    }

    protected AbstractTableHandler(TableBeans tableBeans) {
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
                resultList.add(this.handler(i));
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

    public abstract Map<String, Object> handler(int index) throws IndexOutOfBoundsException;
}
