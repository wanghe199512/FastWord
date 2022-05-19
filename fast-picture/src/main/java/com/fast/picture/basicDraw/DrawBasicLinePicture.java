package com.fast.picture.basicDraw;

import com.fast.picture.handler.DefaultXYDatasetHandler;
import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.text.NumberFormat;
import java.util.List;

/**
 * @author wanghe
 * 折线图
 */
public class DrawBasicLinePicture extends AbstractDrawBasicPicture {

    public DrawBasicLinePicture(String title, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(title, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createLineChart(this.title, this.XAxisLabel, this.YAxisLabel, (CategoryDataset) this.dataset,
                PlotOrientation.VERTICAL, true, true, false);
        super.setLineRender(chart.getCategoryPlot(), true, true);
        chart.setTextAntiAlias(true);
        return chart;
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultXYDatasetHandler(), DefaultCategoryDataset.class);
    }

}
