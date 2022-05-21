package com.fast.word.annotation;

import com.fast.annotation.FastWordTabled;

import java.lang.reflect.Field;
import java.util.List;

/**
 * FastWordTabled注解处理器
 *
 * @author wanghe
 */
public interface IFastWordTabled extends IFastWord<FastWordTabled> {

    List<List<Object>> geTabledColumnList(List<Object> beans, Field[] declaredFields);

    List<String> getTabledColumnNames(Field[] declaredFields);
}
