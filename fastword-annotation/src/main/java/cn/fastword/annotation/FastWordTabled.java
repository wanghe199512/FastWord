package cn.fastword.annotation;

import cn.fastword.annotation.enums.DstRule;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 定义文档导出表格注解
 * title:标识表格头名称
 * desc：字段描述说明
 * dstRule：数据脱敏规则，默认不处理，支持手机号，车牌号等脱敏
 * sort：自定义表格排序
 * @deprecated 作用于实体字段
 */
public @interface FastWordTabled {

    String title() default "";

    String desc() default "";

    DstRule dstRule() default DstRule.NONE;

    int sort() default 0;
}
