package cn.fastword.word.annotation;

import cn.fastword.annotation.FastWordTabled;

import java.lang.reflect.Field;
import java.util.List;

/**
 * FastWordTabled注解处理器
 *
 * @author wanghe
 * @see IFastWord
 */
public interface IFastWordColumn extends IFastWord<FastWordTabled> {
    /**
     * 获取表格列数据
     *
     * @param beans          实体对象list
     * @param declaredFields 反射获取的Field对象
     * @return 表格数据
     */
    List<List<?>> geTabledColumnList(List<?> beans, Field[] declaredFields);

    /**
     * 获取表格头
     *
     * @param declaredFields 反射获取的Field对象
     * @return 表格头数据
     */
    List<String> getTabledColumnNames(Field[] declaredFields);
}
