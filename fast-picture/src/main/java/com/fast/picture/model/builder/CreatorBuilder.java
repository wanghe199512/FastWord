package com.fast.picture.model.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建工具类
 *
 * @author wanghe
 */
public class CreatorBuilder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static List<LinkedList<? extends Number>> singletonYAxisList(LinkedList<Collection<String>> YAxisLabelList) {
        if (YAxisLabelList == null || YAxisLabelList.size() == 0) {
            throw new RuntimeException("linkedLists is null or linkedLists size = 0, please check it!");
        }
        try {
            return YAxisLabelList.stream().map(Collection::iterator).map(stringIterator -> Stream.of(stringIterator.next().split(","))
                    .map(Double::new).collect(Collectors.toCollection(LinkedList::new))).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("自动解析转换类型错误，List<Object>实际类型当前仅支持：:Number子类对象,String。" +
                    "注意:最终都会自动转换为数值类型，因此Object必须为数值", e);
        }
    }
}
