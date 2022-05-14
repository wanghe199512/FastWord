package com.fast.picture.basicDraw;

import com.fast.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

/**
 * @author wanghe
 * 柱状图
 */
public class DrawBasicBarPicture extends AbstractDrawBasicPicture {

    public DrawBasicBarPicture(String defaultTitle, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(defaultTitle, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {
        return ChartFactory.createBarChart(this.defaultTitle, this.XAxisLabel, this.YAxisLabel, (CategoryDataset) this.dataset,
                PlotOrientation.VERTICAL, true, true, false);
    }

}
