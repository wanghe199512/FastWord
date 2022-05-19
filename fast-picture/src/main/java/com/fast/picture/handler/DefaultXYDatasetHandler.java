package com.fast.picture.handler;

import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.DefaultXYDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;

import java.util.List;

/**
 * 默认数据处理器
 *
 * @author wanghe
 * 涉及到x，y轴坐标数据的均由此处理器处理
 */
public class DefaultXYDatasetHandler implements IDatasetHandler {

    private Object defaultDataset = null;

    public Object getDefaultDataset() {
        return defaultDataset;
    }

    public DefaultXYDatasetHandler setDefaultDataset(Object defaultDataset) {
        this.defaultDataset = defaultDataset;
        return this;
    }

    @Override
    public Dataset handler(List<? extends BasicDataset> dataSetList, Class<?> cls) throws IllegalAccessException, InstantiationException {
        this.defaultDataset = cls.newInstance();
        for (BasicDataset dataset : dataSetList) {
            List<?> XAxisList = ((DefaultXYDataset) dataset).getXAxisLabelList(), YAxisLabelList = ((DefaultXYDataset) dataset).getYAxisLabelList(), legends = dataset.getLegendNames();
            for (int i = 0; i < legends.size(); i++) {     // 根据图例顺序，对应纵轴数值数据集list
                for (int j = 0; j < XAxisList.size(); j++) {
                    this.addValue(((List<?>) YAxisLabelList.get(i)).get(j), legends.get(i), XAxisList.get(j));
                }
            }
        }
        return (Dataset) this.defaultDataset;
    }

    @Override
    public void addValue(Object value, Object rowName, Object columnName) {
        if (this.defaultDataset instanceof DefaultCategoryDataset) {
            ((DefaultCategoryDataset) this.defaultDataset).addValue((Number) value, (String) rowName, (String) columnName);
        }
        if (this.defaultDataset instanceof DefaultMultiValueCategoryDataset) {
            ((DefaultMultiValueCategoryDataset) this.defaultDataset).add((List<?>) value, (String) rowName, (String) columnName);
        }
    }
}
