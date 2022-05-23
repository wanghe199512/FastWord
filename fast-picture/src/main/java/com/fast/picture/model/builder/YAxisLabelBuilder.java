package com.fast.picture.model.builder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * YAxisLabel数据转换工具类
 *
 * @author wanghe
 */
public class YAxisLabelBuilder {

    public static List<LinkedList<? extends Number>> getYAxisLabelGroupList(LinkedList<Collection<String>> searchList) {
        return YAxisLabelBuilder.getYAxisLabelGroupList(searchList, ",");
    }

    public static List<LinkedList<? extends Number>> getYAxisLabelGroupList(LinkedList<Collection<String>> searchList, String separator) {
        if (searchList == null || searchList.size() == 0) {
            throw new RuntimeException("searchList is null or searchList size = 0, please check it!");
        }
        return searchList.stream().map(Collection::iterator).map(iterator ->
                Stream.of(iterator.next().split(separator)).map(Double::new).collect(Collectors.toCollection(LinkedList::new))).collect(Collectors.toList());
    }

    public static List<List<? extends Number>> getYAxisLabelList(LinkedList<String> searchList) {
        return YAxisLabelBuilder.getYAxisLabelList(searchList, ",");
    }

    public static List<List<? extends Number>> getYAxisLabelList(LinkedList<String> searchList, String separator) {
        return searchList.stream().map(item -> Stream.of(item.split(",")).map(Double::valueOf).collect(Collectors.toList())).collect(Collectors.toList());
    }
}
