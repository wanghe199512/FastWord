package cn.fastword.picture.handler;

import cn.fastword.picture.model.DefaultEChartsDataset;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.series.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认数据处理器
 *
 * @author wanghe
 */
public class DefaultEChartsDatasetHandler implements IDatasetHandler<Option> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private DefaultEChartsDataset dataset;

    private Option option;

    private Class<?> cls;

    public DefaultEChartsDatasetHandler(Class<?> cls, Option option, DefaultEChartsDataset dataset) {
        this.option = option;
        this.cls = cls;
        this.dataset = dataset;
    }

    @Override
    public Option handler() throws Exception {
        for (int i = 0; i < this.dataset.getLegendList().length; i++) {
            Series<?> series = (Series<?>) this.cls.newInstance();
            for (int j = 0; j < this.dataset.getDataList()[i].length; j++) {
                series.data(this.dataset.getDataList()[i][j]);
            }
            series.name(this.dataset.getLegendList()[i]);
            option.series(series);
        }
        CategoryAxis category = new CategoryAxis().data((Object) this.dataset.getLabelList());// 轴分类
        this.option.xAxis(category);
        return this.option;
    }

    public DefaultEChartsDatasetHandler setDataset(DefaultEChartsDataset dataset) {
        this.dataset = dataset;
        return this;
    }

    public DefaultEChartsDatasetHandler setOption(Option option) {
        this.option = option;
        return this;
    }

    public DefaultEChartsDatasetHandler setCls(Class<?> cls) {
        this.cls = cls;
        return this;
    }
}
