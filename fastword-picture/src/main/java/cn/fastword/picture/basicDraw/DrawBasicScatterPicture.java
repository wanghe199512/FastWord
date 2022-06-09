package cn.fastword.picture.basicDraw;

import cn.fastword.picture.handler.DefaultCriteriaDatasetHandler;
import cn.fastword.picture.model.BasicDataset;
import cn.fastword.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
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
        JFreeChart chart = ChartFactory.createScatterPlot(
                this.title, this.XAxisLabel, this.YAxisLabel, (XYSeriesCollection) this.dataset, PlotOrientation.VERTICAL, true, true, false
        );
        XYPlot scatterPlot = (XYPlot) chart.getPlot();
        scatterPlot.setInsets(new RectangleInsets(5, 10, 10, 10), true);
        return chart;
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultCriteriaDatasetHandler(), XYSeriesCollection.class);

    }

}
