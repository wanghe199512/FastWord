package cn.fastword.word.handller;

import cn.fastword.word.annotation.IFastWordTabled;
import cn.fastword.annotation.FastWordTabled;
import cn.fastword.word.beans.TableBeans;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 默认基于注解的表格处理
 *
 * @author wanghe
 */
public class DefaultAnnotationTableHandler extends DefaultTableBeansHandler implements IFastWordTabled {

    public DefaultAnnotationTableHandler(List<?> beans, Class<?> beanCls) {
        this.tableBeans = new TableBeans(this.getTabledColumnNames(this.getDeclaredFields(beanCls)), this.geTabledColumnList(beans, this.getDeclaredFields(beanCls)));
    }

    @Override
    public List<List<?>> geTabledColumnList(List<?> beans, Field[] declaredFields) {
        return new LinkedList<Object>(beans).stream().map(bean -> new LinkedList<Field>(Arrays.asList(declaredFields)).stream().map(field -> {
            try {
                return field.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return field;
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }

    // TODO 排序算法待实现
    private void sorted() {

    }

    @Override
    public List<String> getTabledColumnNames(Field[] declaredFields) {
        return new LinkedList<Field>(Arrays.asList(declaredFields)).stream().map(field -> this.getAnnotation(field).title()).collect(Collectors.toList());
    }

    @Override
    public Field[] getDeclaredFields(Class<?> cls) {
        return cls.getDeclaredFields();
    }

    @Override
    public FastWordTabled getAnnotation(Field field) {
        field.setAccessible(true);
        return field.getAnnotation(FastWordTabled.class);
    }
}
