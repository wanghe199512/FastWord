package cn.fastword.word.handller;

import java.util.List;
import java.util.Map;

public interface ITableBeans {

    List<Map<String, Object>> createTable();

    Map<String, Object> handler(int index) throws ArrayIndexOutOfBoundsException;
}
