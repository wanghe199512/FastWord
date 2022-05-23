package cn.fastword.picture.model;

import cn.fastword.picture.model.builder.YAxisLabelBuilder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 默认绘图数据集对象
 * <p>构建适用范围：涉及到x，y轴坐标数据 ,Y轴数据限定为LinkedList,用来确保Y轴与X轴刻度始终一一对应</p>
 * <p>那么如何选择合适的构造器构建我的数据? </p>
 *
 * 后记：作为开发者深知组装数据的痛苦，具体场景也无法一一枚举，于是我在框架提供了适用于DefaultXYDataset数据集对象参数: YAxisLabelList常用数据转换工具
 * @see YAxisLabelBuilder  常用数据转换工具
 * @author wanghe
 */
public class DefaultXYDataset extends BasicDataset {
    /**
     * x坐标数据
     */
    private List<? extends LinkedList<? extends Number>> YAxisLabelList;
    /**
     * y轴坐标数据
     */
    private List<String> XAxisLabelList;

    public DefaultXYDataset() {
    }

    /**
     * 单图例构建
     *
     * @param legendName     图例
     * @param YAxisLabelList y轴数据
     * @param XAxisLabelList x轴列
     */
    public DefaultXYDataset(String legendName, LinkedList<? extends Number> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendName);
        this.YAxisLabelList = Collections.singletonList(YAxisLabelList);
        this.XAxisLabelList = XAxisLabelList;
    }

    /**
     * 多图例构建
     *
     * @param legendNames    图例组
     * @param YAxisLabelList y轴数据
     * @param XAxisLabelList x轴列
     */
    public DefaultXYDataset(String[] legendNames, List<? extends LinkedList<? extends Number>> YAxisLabelList, List<String> XAxisLabelList) {
        super(legendNames);
        this.XAxisLabelList = XAxisLabelList;
        this.YAxisLabelList = YAxisLabelList;
    }

    public List<? extends LinkedList<? extends Number>> getYAxisLabelList() {
        return YAxisLabelList;
    }

    public DefaultXYDataset setYAxisLabelList(List<LinkedList<? extends Number>> YAxisLabelList) {
        this.YAxisLabelList = YAxisLabelList;
        return this;
    }

    public List<String> getXAxisLabelList() {
        return XAxisLabelList;
    }

    public DefaultXYDataset setXAxisLabelList(List<String> XAxisLabelList) {
        this.XAxisLabelList = XAxisLabelList;
        return this;
    }
}
