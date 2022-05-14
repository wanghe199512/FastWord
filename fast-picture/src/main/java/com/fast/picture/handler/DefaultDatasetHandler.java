package com.fast.picture.handler;

import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.DefaultDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import java.util.List;

/**
 * 默认柱状，折线 数据处理器
 *
 * @author
 */
public class DefaultDatasetHandler implements IDatasetHandler {

    public Dataset addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
        for (BasicDataset dataset : dataSetList) {
            List<?> XAxisList = ((DefaultDataset) dataset).getXAxisLabelList(), YAxisList = ((DefaultDataset) dataset).getYAxisLabelList();
            for (int i = 0; i < XAxisList.size(); i++) {
                defaultDataset.addValue((Number) YAxisList.get(i), dataset.getDataSetName(), (String) XAxisList.get(i));
            }
        }
        return defaultDataset;
    }
}
