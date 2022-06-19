package cn.fastword.word.handler.table;

import java.util.List;

public interface ITableBeans<T> {

    List<T> createTable();

    T handler(int index) throws ArrayIndexOutOfBoundsException;
}
