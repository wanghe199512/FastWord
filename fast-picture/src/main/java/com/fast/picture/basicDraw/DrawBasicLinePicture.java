package com.fast.picture.basicDraw;

import com.fast.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

/**
 * @author wanghe
 * 折线图
 */
public class DrawBasicLinePicture extends AbstractDrawBasicPicture {

    public DrawBasicLinePicture(String defaultTitle, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(defaultTitle, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {
        return ChartFactory.createLineChart(this.defaultTitle, this.XAxisLabel, this.YAxisLabel, (CategoryDataset) this.dataset,
                PlotOrientation.VERTICAL, true, true, false);
    }

}
