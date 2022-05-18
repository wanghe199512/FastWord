package com.fast.word.handller;

import java.util.List;
import java.util.Map;

public interface ITableBeansHandler {

    List<Map<String, Object>> createTable();

    Map<String, Object> createTableHandler(int index) throws ArrayIndexOutOfBoundsException;
}
