package cn.fastword.word.document;

import cn.fastword.word.beans.TableBeans;
import cn.fastword.word.handler.table.ITableBeans;

import java.util.List;

public interface IFastTable<T> {

    void addTable(ITableBeans<T> handler);

    void addParagraphTableRows(ITableBeans<T> handler, String... texts);

    void addParagraphTableRows(TableBeans tableBeans, String... texts);

    void addParagraphTableRows(List<?> beans, Class<?> beanCls, String... texts);
}
