package com.fast.picture.basicDraw;

import com.fast.picture.handler.DefaultXYDatasetHandler;
import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.Picture;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import java.text.NumberFormat;
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
