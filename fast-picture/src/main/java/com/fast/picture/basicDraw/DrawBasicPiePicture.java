package com.fast.picture.basicDraw;

import com.fast.picture.handler.DefaultCriteriaDatasetHandler;
import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.List;

/**
 * @author wanghe
 * 饼图
 */
public class DrawBasicPiePicture extends AbstractDrawBasicPicture {

    public DrawBasicPiePicture(String defaultTitle, Picture picture) {
        super(defaultTitle, null, null, picture);
    }

    @Override
    public JFreeChart createChart() {
        return ChartFactory.createPieChart(this.defaultTitle, (DefaultPieDataset) this.dataset);
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultCriteriaDatasetHandler(), DefaultPieDataset.class);
    }
}
