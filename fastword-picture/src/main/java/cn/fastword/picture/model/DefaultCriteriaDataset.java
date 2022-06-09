package cn.fastword.picture.model;

/**
 * 默认绘图数据集对象
 *
 * @author wanghe
 */
public class DefaultCriteriaDataset extends BasicDataset {
    /**
     * 纵轴数值
     */
    public Number value;
    /**
     * 横轴数值
     */
    public Number XAxisLabel;

    public DefaultCriteriaDataset() {
    }

    public DefaultCriteriaDataset(String legendName, Number value, Number XAxisLabel) {
        super(legendName);
        this.XAxisLabel = XAxisLabel;
        this.value = value;
    }

    public DefaultCriteriaDataset(String legendName, Number value) {
        super(legendName);
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public DefaultCriteriaDataset setValue(Number value) {
        this.value = value;
        return this;
    }

    public Number getXAxisLabel() {
        return XAxisLabel;
    }

    public DefaultCriteriaDataset setXAxisLabel(Number XAxisLabel) {
        this.XAxisLabel = XAxisLabel;
        return this;
    }
}
