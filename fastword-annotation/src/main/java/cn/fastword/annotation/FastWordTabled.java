package cn.fastword.annotation;

import cn.fastword.annotation.enums.DstRule;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 定义文档导出表格注解
 * @deprecated 作用于类
 */
public @interface FastWordTabled {
    /**
     * 表格宽度
     *
     * @return width
     */
    int width() default 2000;

    /**
     * 表格单元格列宽
     * 注意：此列宽优先级大于FastWordColumn中的自定义列宽，
     * 且只有在注解处理器时，FastWordColumn自定义列宽才会生效，否则使用此列宽（默认：根据文字内容自适应），
     *
     * @return 0
     */
    int cellWidth() default 0;

    /**
     * 表格全局内边距（依次为：上，左，下，右）
     *
     * @return margin
     */
    int[] margin() default {30, 30, 20, 20};

    /**
     * 显示斑马线
     *
     * @return false
     */
    boolean showZebra() default false;

    /**
     * 定义斑马线颜色
     *
     * @return []
     */
    String[] zebraColor() default {"D3DFEE", "EDF2F8"};

    /**
     * 行高
     *
     * @return 100
     */
    int rowHeight() default 100;

    /**
     * 标题加粗
     */
    boolean headerFontBold() default true;

}
