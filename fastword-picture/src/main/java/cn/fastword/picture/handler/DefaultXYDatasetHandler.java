package cn.fastword.picture.handler;

import cn.fastword.picture.model.DefaultXYDataset;
import cn.fastword.picture.model.BasicDataset;
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
            this.XAxisList = ((DefaultXYDataset) dataset).getXAxisLabelList();
            this.YAxisLabelList = ((DefaultXYDataset) dataset).getYAxisLabelList();
            this.legends = dataset.getLegendNames();
            for (int i = 0; i < legends.size(); i++) {     // 以图例个数为基准循环
                for (int j = 0; j < this.XAxisList.size(); j++) {  // 取嵌套循环list进行循环，
                    if (this.YAxisLabelList.get(i).size() > j) {
                        if (this.defaultDataset instanceof DefaultCategoryDataset) {
                            ((DefaultCategoryDataset) this.defaultDataset).addValue((this.YAxisLabelList.get(i)).get(j), legends.get(i), XAxisList.get(j));
                        }
                    }
                }
            }
        }
        return (Dataset) this.defaultDataset;
    }
}
