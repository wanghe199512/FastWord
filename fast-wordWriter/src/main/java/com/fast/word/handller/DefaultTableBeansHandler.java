package com.fast.word.handller;

import com.fast.word.beans.TableBeans;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 默认的table表格数据处理器
 *
 * @author wanghe
 */
public class DefaultTableBeansHandler extends AbstractDefaultTableBeansHandler {

    public DefaultTableBeansHandler(TableBeans tableBeans) {
        super(tableBeans);
    }

    @Override
    public Map<String, Object> getTableHandler(int index) throws ArrayIndexOutOfBoundsException {
        Map<String, Object> resultLinkedMap = new LinkedHashMap<>();
        for (int j = 0; j < this.tableBeans.getTitleColumn().size(); j++) {
            if (this.tableBeans.getTitleColumn().size() != this.tableBeans.getColumnList().get(index).size()) {
                throw new ArrayIndexOutOfBoundsException("表格标题必须与表格内容元素长度相等，本次进程终止...");
            }
            resultLinkedMap.put(this.tableBeans.getTitleColumn().get(j), this.tableBeans.getColumnList().get(index).get(j));
        }
        logger.info("==> Preparing: {}", resultLinkedMap.toString());
        return resultLinkedMap;
    }
}
