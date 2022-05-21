package com.fast.annotation;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 定义文档导出表格注解
 * @deprecated 作用于实体
 */
public @interface FastWordTabled {
    String title();

    String description() default "";
    
    @Deprecated
    int order();
}
