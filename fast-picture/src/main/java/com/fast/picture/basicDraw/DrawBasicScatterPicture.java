package com.fast.picture.basicDraw;

import com.fast.picture.handler.DefaultXYDatasetHandler;
import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.Picture;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;

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
        return new JFreeChart(this.title, new CategoryPlot((DefaultMultiValueCategoryDataset) this.dataset, new CategoryAxis(this.XAxisLabel), new NumberAxis(this.YAxisLabel), new ScatterRenderer()));
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList,new DefaultXYDatasetHandler(), DefaultMultiValueCategoryDataset.class);
    }

}
