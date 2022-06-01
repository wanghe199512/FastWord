package cn.fastword.word.handller;

import cn.fastword.annotation.FastWordTabled;
import cn.fastword.word.annotation.IFastWordTabled;
import cn.fastword.word.beans.TableBeans;
import cn.hutool.core.util.DesensitizedUtil;

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
        return new LinkedList<Object>(beans).stream().map(bean -> new LinkedList<>(Arrays.asList(declaredFields)).stream().map(field -> {
            try {
                return this.desensitized(field, (String) field.get(bean));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::isNull).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private Field[] sorted(Field[] fields) {
        return Arrays.stream(fields).filter(a -> this.getAnnotation(a) != null).sorted(Comparator.comparingInt(a -> this.getAnnotation(a).sort())).toArray(Field[]::new);
    }

    private Object desensitized(Field field, String str) {
        return str;
    }

    @Override
    public List<String> getTabledColumnNames(Field[] declaredFields) {
        return new LinkedList<>(Arrays.asList(declaredFields)).stream().map(field -> this.getAnnotation(field).title()).collect(Collectors.toList());
    }

    @Override
    public Field[] getDeclaredFields(Class<?> cls) {
        return this.sorted(cls.getDeclaredFields());
    }

    @Override
    public FastWordTabled getAnnotation(Field field) {
        field.setAccessible(true);
        return field.getAnnotation(FastWordTabled.class);
    }
}
