package cn.fastword.picture.handler;

import cn.fastword.picture.model.DefaultCriteriaDataset;
import cn.fastword.picture.model.BasicDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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
        if (this.defaultDataset instanceof DefaultPieDataset) {
            for (BasicDataset dataset : dataSetList) {
                ((DefaultPieDataset) this.defaultDataset).setValue(dataset.getLegendNames().get(0), ((DefaultCriteriaDataset) dataset).getValue());
            }
        }
        if (this.defaultDataset instanceof XYSeriesCollection) {
            List<String> legendList = dataSetList.stream().map(legend -> legend.getLegendNames().get(0)).distinct().collect(Collectors.toList());
            for (String legend : legendList) {
                XYSeries series = new XYSeries(legend);
                for (int i = 0; i < dataSetList.size(); i++) {
                    if (legend.equals(dataSetList.get(i).getLegendNames().get(0))) {
                        series.add(((DefaultCriteriaDataset) dataSetList.get(i)).getValue(), ((DefaultCriteriaDataset) dataSetList.get(i)).getXAxisLabel());
                    }
                }
                ((XYSeriesCollection) this.defaultDataset).addSeries(series);
            }
        }
        return (Dataset) this.defaultDataset;
    }
}
