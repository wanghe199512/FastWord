package cn.fastword.word.handller;

import java.util.List;
import java.util.Map;

public interface ITableBeans<T> {

    List<T> createTable();

    T handler(int index) throws ArrayIndexOutOfBoundsException;
}
