package cn.fastword.annotation;

import cn.fastword.annotation.enums.DstRule;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/*
 * 定义文档导出表格注解
 * @deprecated 作用于实体字段
 */
public @interface FastWordColumn {
    /**
     * 列标题
     *
     * @return title
     */
    String title() default "";

    /**
     * 列描述
     *
     * @return desc
     */
    String desc() default "";

    /**
     * 数据脱敏规则
     *
     * @return NONE
     */
    DstRule dstRule() default DstRule.NONE;

    /**
     * 自定义列字段排序
     *
     * @return sort
     */
    int sort() default 0;

    /**
     * 自定义单元格列宽
     *
     * @return cellWidth
     */
    int cellWidth() default 0;
}
