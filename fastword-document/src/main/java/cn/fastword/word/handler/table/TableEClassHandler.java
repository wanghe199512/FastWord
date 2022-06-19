package cn.fastword.word.handler.table;

import cn.fastword.annotation.FastWordColumn;
import cn.fastword.word.annotation.IFastWordColumn;
import cn.fastword.word.beans.TableBeans;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 默认基于注解的表格处理
 *
 * @author wanghe
 */
public class TableEClassHandler extends AbstractITableBeansHandler implements IFastWordColumn {

    public TableEClassHandler(List<?> beans, Class<?> beanCls) {
        this.tableBeans = new TableBeans(this.getTabledColumnNames(this.getDeclaredFields(beanCls)),
                this.geTabledColumnList(beans, this.getDeclaredFields(beanCls)));
    }

    /**
     * 获取表格列数据
     *
     * @param beans          实体对象list
     * @param declaredFields 反射获取的Field对象
     * @return 列数据
     */
    @Override
    public List<List<?>> geTabledColumnList(List<?> beans, Field[] declaredFields) {
        return new LinkedList<Object>(beans).stream().map(bean -> new LinkedList<>(Arrays.asList(declaredFields)).
                stream().map(field -> {
            try {
                return this.desensitized(field, field.get(bean));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }

    /**
     * 列排序
     *
     * @param fields 反射字段
     * @return 排序后字段
     */
    private Field[] sorted(Field[] fields) {
        return Arrays.stream(fields).filter(a -> this.getAnnotation(a) != null).sorted(Comparator.comparingInt(a -> this.getAnnotation(a).sort())).toArray(Field[]::new);
    }

    /**
     * 数据脱敏
     *
     * @param field   反射字段
     * @param content 脱敏数据
     * @return 脱敏后数据
     */
    private Object desensitized(Field field, Object content) {
        return this.getAnnotation(field).dstRule().result(content);
    }

    /**
     * 获取表格列标题
     *
     * @param declaredFields 反射获取的Field对象
     * @return 表格头数据
     */
    @Override
    public List<String> getTabledColumnNames(Field[] declaredFields) {
        return new LinkedList<>(Arrays.asList(declaredFields)).stream().map(field -> this.getAnnotation(field).title()).collect(Collectors.toList());
    }

    @Override
    public Field[] getDeclaredFields(Class<?> cls) {
        return this.sorted(cls.getDeclaredFields());
    }

    @Override
    public FastWordColumn getAnnotation(Field field) {
        field.setAccessible(true);
        return field.getAnnotation(FastWordColumn.class);
    }
}
