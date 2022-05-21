package com.fast.picture.handler;

import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.DefaultXYDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 默认数据处理器
 *
 * @author wanghe
 * 涉及到x，y轴坐标数据的均由此处理器处理
 */
public class DefaultXYDatasetHandler implements IDatasetHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Object defaultDataset = null;

    @Override
    public Dataset handler(List<? extends BasicDataset> dataSetList, Class<?> cls) throws IllegalAccessException, InstantiationException {
        this.defaultDataset = cls.newInstance();
        for (BasicDataset dataset : dataSetList) {
            List<?> XAxisList = ((DefaultXYDataset) dataset).getXAxisLabelList(), YAxisLabelList = ((DefaultXYDataset) dataset).getYAxisLabelList(), legends = dataset.getLegendNames();
            for (int i = 0; i < legends.size(); i++) {     // 以图例个数为基准循环
                if (YAxisLabelList.size() <= i) {  // 如果y轴的个数小于等于图例个数，后边的就不用画了
                    continue;
                }
                for (int j = 0; j < ((List<?>) YAxisLabelList.get(i)).size(); j++) {  // 取嵌套循环list进行循环，
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

    public Object getDefaultDataset() {
        return defaultDataset;
    }
}
