package com.fast.word.annotation;

import java.lang.reflect.Field;

public interface IFastWord<T> {

    Field[] getDeclaredFields(Class<?> cls);

    T getAnnotation(Field declaredField);
}
