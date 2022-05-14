package com.fast.word.handller;

import java.util.List;
import java.util.Map;

public interface ITableBeansHandler {

    List<Map<String, Object>> drawTable();

    Map<String, Object> getTableHandler(int index) throws ArrayIndexOutOfBoundsException;
}
