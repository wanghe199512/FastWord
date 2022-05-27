package cn.fastword.picture.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 默认绘图数据集对象
 *
 * @author wanghe
 */
public class DefaultXYDataset {

    private List<String> legendList;
    /**
     * x坐标数据
     */
    private Collection<Number[]> dataList;
    /**
     * y轴坐标数据
     */
    private Collection<String[]> labelList;

    public DefaultXYDataset() {
    }

    public DefaultXYDataset(String legendName, Number[] dataList, String... labelList) {
        this(Collections.singletonList(legendName), Collections.singleton(dataList), Collections.singleton(labelList));
    }

    public DefaultXYDataset(List<String> legendList, Collection<Number[]> dataList, Collection<String[]> labelList) {
        this.legendList = legendList;
        this.labelList = labelList;
        this.dataList = dataList;
    }

    public List<String> getLegendList() {
        return legendList;
    }

    public DefaultXYDataset setLegendList(List<String> legendList) {
        this.legendList = legendList;
        return this;
    }

    public Collection<Number[]> getDataList() {
        return dataList;
    }

    public DefaultXYDataset setDataList(Collection<Number[]> dataList) {
        this.dataList = dataList;
        return this;
    }

    public Collection<? extends String[]> getLabelList() {
        return labelList;
    }

    public DefaultXYDataset setLabelList(Collection<String[]> labelList) {
        this.labelList = labelList;
        return this;
    }
}
