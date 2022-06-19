package cn.fastword.word.handler.table;

import cn.fastword.word.beans.TableBeans;
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
public abstract class AbstractITableBeansHandler implements ITableBeans<Map<String, Object>> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 表格数据实体
     */
    protected TableBeans tableBeans = null;

    protected AbstractITableBeansHandler() {
    }

    protected AbstractITableBeansHandler(TableBeans tableBeans) {
        if (tableBeans == null) {
            throw new RuntimeException("请先初始化tableBeans ...");
        }
        this.tableBeans = tableBeans;
    }

    @Override
    public List<Map<String, Object>> createTable() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        if (this.tableBeans.getDataList().size() > 0) {
            for (int i = 0; i < this.tableBeans.getDataList().size(); i++) {
                resultList.add(this.handler(i));
            }
        }
        if (this.tableBeans.getDataList().size() == 0 && this.tableBeans.isShowHeaderOfNoneList()) {   // 只有在dataList数据为空时，showHeader生效
            resultList.add(this.createNullTable()); // 当数据为空时，也显示表头
        }
        return resultList;
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

    @Override
    public Map<String, Object> handler(int index) throws ArrayIndexOutOfBoundsException {
        Map<String, Object> resultLinkedMap = new LinkedHashMap<>();
        for (int j = 0; j < this.tableBeans.getTitles().size(); j++) {
            if (this.tableBeans.getDataList().get(index).size() == 0) {
                break;
            }
            resultLinkedMap.put(this.tableBeans.getTitles().get(j), this.tableBeans.getDataList().get(index).get(j));
        }
        logger.info("==> Preparing: {}", resultLinkedMap.toString());
        return resultLinkedMap;
    }
}
