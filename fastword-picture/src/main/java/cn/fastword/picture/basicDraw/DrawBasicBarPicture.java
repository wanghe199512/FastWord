package cn.fastword.picture.basicDraw;

import cn.fastword.picture.handler.DefaultXYDatasetHandler;
import cn.fastword.picture.model.BasicDataset;
import cn.fastword.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

/**
 * @author wanghe
 * 柱状图
 */
public class DrawBasicBarPicture extends AbstractDrawBasicPicture {

    public DrawBasicBarPicture(String title, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(title, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {

        JFreeChart chart = ChartFactory.createBarChart(this.title, this.XAxisLabel, this.YAxisLabel, (CategoryDataset) this.dataset,
                PlotOrientation.VERTICAL, true, true, false);
        super.setBarRenderer(chart.getCategoryPlot(), true);
        return chart;
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultXYDatasetHandler(), DefaultCategoryDataset.class);
    }
}
