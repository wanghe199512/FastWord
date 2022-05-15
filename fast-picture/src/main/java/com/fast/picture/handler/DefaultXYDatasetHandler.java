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

    public Dataset handler(List<? extends BasicDataset> dataSetList, Class<?> cls) throws IllegalAccessException, InstantiationException {
        this.defaultDataset = cls.newInstance();
        for (BasicDataset dataset : dataSetList) {
            List<?> XAxisList = ((DefaultXYDataset) dataset).getXAxisLabelList(), YAxisList = ((DefaultXYDataset) dataset).getYAxisLabelList();
            if (XAxisList.size() != YAxisList.size()) {
                throw new RuntimeException("XAxisList，YAxisList长度必须一致，本次进程终止...");
            }
            for (int i = 0; i < XAxisList.size(); i++) {
                this.addValue(YAxisList.get(i), dataset.getDataSetName(), (String) XAxisList.get(i));
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
