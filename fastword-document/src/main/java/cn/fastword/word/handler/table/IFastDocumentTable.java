package cn.fastword.word.handler.table;

import cn.fastword.word.beans.TableBeans;

import java.util.List;

/**
 * 表格实现能力
 *
 * @param <T>
 * @author wanghe
 */
public interface IFastDocumentTable<T> {

    void addTable(ITableBeans<T> handler);

    void addParagraphTableRows(ITableBeans<T> handler, String... texts);

    void addParagraphTableRows(TableBeans tableBeans, String... texts);

    void addParagraphTableRows(List<?> beans, Class<?> beanCls, String... texts);
}
