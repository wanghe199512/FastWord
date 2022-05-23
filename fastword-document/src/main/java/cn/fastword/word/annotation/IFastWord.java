package cn.fastword.word.annotation;

import java.lang.reflect.Field;

/**
 * 反射注解
 *
 * @param <T> 实际注解对象
 * @author wanghe
 */
public interface IFastWord<T> {
    /**
     * 反射获取类对象字段
     *
     * @param cls 类对象
     * @return Field
     */
    Field[] getDeclaredFields(Class<?> cls);

    /**
     * 反射获取注解对象
     *
     * @param declaredField Field
     * @return 实际注解对象
     */
    T getAnnotation(Field declaredField);
}
