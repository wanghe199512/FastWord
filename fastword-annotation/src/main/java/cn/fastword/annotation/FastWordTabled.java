package cn.fastword.annotation;

import cn.fastword.annotation.enums.DesensitizedRule;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 定义文档导出表格注解
 * @deprecated 作用于实体
 */
public @interface FastWordTabled {

    String title() default "";

    String desc() default "";

    DesensitizedRule dstRule() default DesensitizedRule.NONE;

    int sort() default 0;
}
