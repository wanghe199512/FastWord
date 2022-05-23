package cn.fastword.picture.basicDraw;

import cn.fastword.picture.handler.DefaultXYDatasetHandler;
import cn.fastword.picture.model.BasicDataset;
import cn.fastword.picture.model.Picture;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.ui.RectangleInsets;

import java.util.List;

/**
 * @author wanghe
 * 散点图
 */
public class DrawBasicScatterPicture extends AbstractDrawBasicPicture {

    public DrawBasicScatterPicture(String title, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(title, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {
        JFreeChart chart = new JFreeChart(this.title, new CategoryPlot((DefaultMultiValueCategoryDataset) this.dataset, new CategoryAxis(this.XAxisLabel), new NumberAxis(this.YAxisLabel), new ScatterRenderer()));
        CategoryPlot scatterPlot = (CategoryPlot) chart.getPlot();
        scatterPlot.setInsets(new RectangleInsets(5, 10, 10, 10), true);
        return chart;
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultXYDatasetHandler(), DefaultMultiValueCategoryDataset.class);
    }

}
