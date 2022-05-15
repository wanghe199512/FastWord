package com.fast.picture.handler;

import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.DefaultCriteriaDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.List;

/**
 * 普通处理器
 *
 * @author wanghe
 */
public class DefaultCriteriaDatasetHandler implements IDatasetHandler {

    private Object defaultDataset = null;

    @Override
    public Dataset handler(List<? extends BasicDataset> dataSetList, Class<?> cls) throws IllegalAccessException, InstantiationException {
        this.defaultDataset = cls.newInstance();
        for (BasicDataset dataset : dataSetList) {
            this.addValue("", dataset.getDataSetName(), ((DefaultCriteriaDataset) dataset).getValue());
        }
        return (Dataset) this.defaultDataset;
    }

    @Override
    public void addValue(Object value, Object rowName, Object columnName) {
        if (this.defaultDataset instanceof DefaultPieDataset) {
            ((DefaultPieDataset) this.defaultDataset).setValue((String) rowName, (Number) columnName);
        }
    }
}
