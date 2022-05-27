package cn.fastword.picture.handler;

import cn.fastword.picture.model.DefaultXYDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * 默认数据处理器
 *
 * @author wanghe
 * 涉及到x，y轴坐标数据的均由此处理器处理
 */
public class DefaultXYDatasetHandler implements IDatasetHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * Dataset
     */
    private Object defaultDataset = null;
    /**
     * 横轴数据
     */
    private List<String> XAxisList = null;
    /**
     * 纵轴数据
     */
    private List<? extends LinkedList<? extends Number>> YAxisLabelList = null;
    /**
     * 图例数据
     */
    private List<String> legends = null;

    @Override
    public Dataset handler(List<? extends BasicDataset> dataSetList, Class<?> cls) throws IllegalAccessException, InstantiationException {
        this.defaultDataset = cls.newInstance();
        for (BasicDataset dataset : dataSetList) {
            this.XAxisList = ((DefaultXYDataset) dataset).getLabelList();
            this.YAxisLabelList = ((DefaultXYDataset) dataset).getDataList();
            this.legends = dataset.getLegendNames();
            for (int i = 0; i < legends.size(); i++) {     // 以图例个数为基准循环
                if (YAxisLabelList.size() <= i)   // 如果y轴的个数小于等于图例个数，后边的就不用画了
                    continue;
                this.addDatasetValue(i);
            }
        }
        return (Dataset) this.defaultDataset;
    }

    /**
     * 添加值
     *
     * @param i 图例下标
     */
    private void addDatasetValue(int i) {
        for (int j = 0; j < (this.YAxisLabelList.get(i)).size(); j++) {  // 取嵌套循环list进行循环，
            if (this.defaultDataset instanceof DefaultCategoryDataset) {
                ((DefaultCategoryDataset) this.defaultDataset).addValue((this.YAxisLabelList.get(i)).get(j), legends.get(i), XAxisList.get(j));
            }
            if (this.defaultDataset instanceof DefaultMultiValueCategoryDataset) {
                ((DefaultMultiValueCategoryDataset) this.defaultDataset).add((YAxisLabelList.get(i)), legends.get(i), XAxisList.get(i));
            }
        }
    }
}
