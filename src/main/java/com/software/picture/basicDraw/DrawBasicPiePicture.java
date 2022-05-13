package com.software.picture.basicDraw;

import com.software.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author wanghe
 * 柱状图
 */
public class DrawBasicPiePicture extends AbstractDrawBasicPicture {

    public DrawBasicPiePicture(String title) {
        super(title);
    }

    public DrawBasicPiePicture(String title, Picture picture) {
        super(title, null, null, picture);
    }

    @Override
    public JFreeChart createChart() {
        return ChartFactory.createPieChart(this.defaultTitle, (DefaultPieDataset) this.dataset);
    }
}
