package cn.fastword.picture.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 默认绘图数据集对象echarts
 *
 * @author wanghe
 */
public class DefaultEChartsDataset {

    private String[] legendList;
    /**
     * x坐标数据
     */
    private Number[][] dataList;
    /**
     * y轴坐标数据
     */
    private String[] labelList;

    public DefaultEChartsDataset() {
    }

    public DefaultEChartsDataset(String[] legendList, Number[][] dataList, String[] labelList) {
        this.legendList = legendList;
        this.labelList = labelList;
        this.dataList = dataList;
    }


    public String[] getLegendList() {
        return legendList;
    }

    public DefaultEChartsDataset setLegendList(String[] legendList) {
        this.legendList = legendList;
        return this;
    }

    public Number[][] getDataList() {
        return dataList;
    }

    public DefaultEChartsDataset setDataList(Number[][] dataList) {
        this.dataList = dataList;
        return this;
    }

    public String[] getLabelList() {
        return labelList;
    }

    public DefaultEChartsDataset setLabelList(String[] labelList) {
        this.labelList = labelList;
        return this;
    }
}
