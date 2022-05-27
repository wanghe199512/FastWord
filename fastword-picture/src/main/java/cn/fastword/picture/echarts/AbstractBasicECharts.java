package cn.fastword.picture.echarts;

import cn.fastword.picture.enums.Report;
import cn.fastword.picture.handler.DefaultEChartsDatasetHandler;
import cn.fastword.picture.model.DefaultEChartsDataset;
import cn.fastword.picture.model.Picture;
import cn.fastword.picture.utils.ApplicationContext;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.json.GsonOption;

import java.io.File;
import java.util.List;

/**
 * 使用echart生成图表
 *
 * @author wanghe
 */
public abstract class AbstractBasicECharts extends ApplicationContext implements IBasicECharts {

    protected DefaultEChartsDataset dataset;

    protected Picture picture;

    protected Option option = new GsonOption();

    private List<String> title;

    protected AbstractBasicECharts() {
    }

    protected AbstractBasicECharts(DefaultEChartsDataset chartsDatasets) {
        this.dataset = chartsDatasets;
    }

    protected AbstractBasicECharts(DefaultEChartsDataset chartsDatasets, Picture picture) {
        this(chartsDatasets);
        this.picture = picture;
        this.title = picture.getTitle();
    }

    public void createChart() {
        if (this.title == null || this.title.size() == 0) {
            throw new RuntimeException("至少需要设置一个主标题，参数不合法.....");
        }
        Title title = new Title().text(this.title.get(0)); // 标题
        if (this.title.size() == 2)
            this.option.title(title.subtext(this.title.get(1)));
    }

    protected Option getOptions(Class<?> cls) throws Exception {
        this.createChart();
        this.option.legend(dataset.getLegendList());
        this.option = new DefaultEChartsDatasetHandler(cls, this.option, this.dataset).handler();
        this.option.yAxis(new ValueAxis());// y轴
        return this.option;
    }

    @Override
    public abstract File saveAsPNG(String savePath, Report report) throws Exception;
}
