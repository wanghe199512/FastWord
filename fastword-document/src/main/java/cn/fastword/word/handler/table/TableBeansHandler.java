package cn.fastword.word.handler.table;

import cn.fastword.word.beans.TableBeans;

/**
 * 默认的table表格数据处理器
 *
 * @author wanghe
 */
public class TableBeansHandler extends AbstractITableBeansHandler {

    public TableBeansHandler() {
        super();
    }

    public TableBeansHandler(TableBeans tableBeans) {
        super(tableBeans);
    }

}
