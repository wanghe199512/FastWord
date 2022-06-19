package cn.fastword.word.annotation;

import cn.fastword.annotation.FastWordColumn;
import cn.fastword.annotation.FastWordTabled;
import cn.fastword.word.common.DefaultTableThemes;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * FastWordTabled注解处理
 *
 * @author wanghe
 */
public class IFastWordTabledAdapter implements IFastWord<FastWordColumn>, Serializable {
    /**
     * 实体class
     */
    protected Class<?> beanCls = null;
    /**
     * 注解参数
     */
    protected DefaultTableThemes themes = null;
    /**
     * 列宽参数
     */
    protected LinkedList<Integer> cellWidthList = null;
    /**
     * 是否设置了全局列宽
     */
    protected boolean isDefaultCellWidth = false;

    /**
     * 默认构造
     */
    protected IFastWordTabledAdapter() {
        super();
    }

    /**
     * 指定样式
     *
     * @param themes DefaultTableThemes 样式
     */
    public IFastWordTabledAdapter(DefaultTableThemes themes) {
        this.themes = themes;
    }

    /**
     * 获取实体注解配置
     *
     * @param beanCls Class
     */
    public IFastWordTabledAdapter(final Class<?> beanCls) {
        if (beanCls == null) {
            throw new RuntimeException("BeanCls is null. please check beanCls,moreover using FastWordTabled annotation");
        }
        this.beanCls = beanCls;
        this.themes = this.getTableAnnotationBean();   // 初始化默认样式参数
    }

    /**
     * 获取实体注解配置实例
     *
     * @param themes DefaultTableThemes 样式
     */
    protected IFastWordTabledAdapter getAdapterInstance(DefaultTableThemes themes) {
        return new IFastWordTabledAdapter(themes);
    }

    /**
     * 获取实体注解配置实例
     *
     * @param beanCls Class
     */
    protected IFastWordTabledAdapter getAdapterInstance(Class<?> beanCls) {
        return new IFastWordTabledAdapter(beanCls);
    }

    /**
     * 获取FastWordTabled 注解参数
     *
     * @return @see FastWordTableThemesBean 实体
     */
    protected DefaultTableThemes getTableAnnotationBean() {
        FastWordTabled annotation = this.getFastTabledAnnotation();
        if (annotation == null) {
            throw new RuntimeException("No annotations were found in the current entity class: " + this.beanCls.getName());
        }
        this.isDefaultCellWidth = annotation.cellWidth() != 0;
        this.cellWidthList = this.getClsCellWidthList();
        return new DefaultTableThemes(annotation.width(), annotation.cellWidth(),
                annotation.margin(), annotation.showZebra(), annotation.zebraColor(), annotation.rowHeight(), annotation.headerFontBold());
    }

    /**
     * 获取实体数据列宽参数 cellWidth
     *
     * @return List<cellWidth>
     */
    protected LinkedList<Integer> getClsCellWidthList() {
        if (this.isDefaultCellWidth) { // 如果有默认全局列宽，终止获取自定义列宽
            return null;
        }
        return new LinkedList<>(Arrays.asList(this.getDeclaredFields(this.beanCls)))
                .stream().filter(a -> this.getAnnotation(a) != null).map(field -> this.getAnnotation(field).cellWidth()).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * 读取FastWordTabled 注解参数
     *
     * @return FastWordTabled
     */
    protected FastWordTabled getFastTabledAnnotation() {
        return this.beanCls.getAnnotation(FastWordTabled.class);
    }

    /**
     * 获取类注解字段
     *
     * @param cls 类对象
     * @return Field[]
     */
    @Override
    public Field[] getDeclaredFields(final Class<?> cls) {
        return cls.getDeclaredFields();
    }

    /**
     * 获取注解
     *
     * @param declaredField Field
     * @return FastWordColumn
     */
    @Override
    public FastWordColumn getAnnotation(final Field declaredField) {
        declaredField.setAccessible(true);
        return declaredField.getAnnotation(FastWordColumn.class);
    }

    /**
     * 获取主题
     *
     * @return DefaultTableThemes
     */
    public DefaultTableThemes getThemes() {
        return this.themes;
    }
}
