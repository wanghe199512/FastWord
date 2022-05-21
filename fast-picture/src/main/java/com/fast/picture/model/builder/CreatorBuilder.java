package com.fast.picture.model.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.math.BigDecimal;
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

    public static List<List<? extends Number>> singletonYAxisList(List<? super List<Object>> linkedLists) {
        if (linkedLists == null || linkedLists.size() == 0) {
            throw new RuntimeException("linkedLists is null or linkedLists size = 0, please check it!");
        }
        Object obj = linkedLists.get(0);  // 获取实际对象 {为提升效率，仅对第一个下标数据类型进行校验。}
        try{
            if (obj instanceof List) {
                if (((List<?>) obj).size() > 0 && ((List<?>) obj).get(0) instanceof Number)
                    return linkedLists.stream().map(item -> ((List<? extends Number>) item)).collect(Collectors.toList());
                if (((List<?>) obj).size() > 0 && ((List<?>) obj).get(0) instanceof String)
                    return linkedLists.stream().map(item -> (List<? extends Number>)
                            ((List<String>) item).stream().map(Double::valueOf).collect(Collectors.toList())).collect(Collectors.toList());
            }
            if (obj instanceof String) {
                return linkedLists.stream().map(item -> Stream.of(item.toString().split(",")).map(Double::valueOf)
                        .collect(Collectors.toList())).collect(Collectors.toList());
            }
        }catch (Exception e){
            throw new RuntimeException("自动解析转换类型错误，List<Object>实际类型当前仅支持：:Number子类对象,String。" +
                    "注意:最终都会自动转换为数值类型，因此Object必须为数值",e);
        }

        return Collections.emptyList();
    }
}
