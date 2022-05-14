package com.fast.picture.basicDraw;

import com.fast.picture.model.Picture;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;

/**
 * @author wanghe
 * 散点图
 */
public class DrawBasicScatterPicture extends AbstractDrawBasicPicture {

    public DrawBasicScatterPicture(String defaultTitle) {
        super(defaultTitle);
    }

    public DrawBasicScatterPicture(String defaultTitle, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(defaultTitle, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {
        return new JFreeChart(this.defaultTitle, new CategoryPlot((DefaultMultiValueCategoryDataset) this.dataset, new CategoryAxis(this.XAxisLabel), new NumberAxis(this.YAxisLabel), new ScatterRenderer()));
    }

}
