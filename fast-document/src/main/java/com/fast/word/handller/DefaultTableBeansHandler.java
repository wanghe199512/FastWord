package com.fast.word.handller;

import com.fast.word.beans.TableBeans;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 默认的table表格数据处理器
 *
 * @author wanghe
 */
public class DefaultTableBeansHandler extends AbstractDefaultTableHandler {

    public DefaultTableBeansHandler(TableBeans tableBeans) {
        super(tableBeans);
    }

    public DefaultTableBeansHandler(String[] titles, List<LinkedHashMap<String, String>> tableList) {
        this.tableBeans = new TableBeans(titles, tableList);
    }

    @Override
    public Map<String, Object> createTableHandler(int index) throws ArrayIndexOutOfBoundsException {
        Map<String, Object> resultLinkedMap = new LinkedHashMap<>();
        for (int j = 0; j < this.tableBeans.getTitles().size(); j++) {
            if (this.tableBeans.getTitles().size() != this.tableBeans.getDataList().get(index).size()) {
                throw new ArrayIndexOutOfBoundsException("表格标题必须与表格内容元素长度相等，本次进程终止...");
            }
            resultLinkedMap.put(this.tableBeans.getTitles().get(j), this.tableBeans.getDataList().get(index).get(j));
        }
        logger.info("==> Preparing: {}", resultLinkedMap.toString());
        return resultLinkedMap;
    }

}
