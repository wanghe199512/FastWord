package com.fast.picture.basicDraw;

import com.fast.picture.enums.Report;
import com.fast.picture.handler.IDatasetHandler;
import com.fast.picture.model.BasicDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

import java.io.File;
import java.util.List;

public interface IDrawBasicPicture {

    JFreeChart createChart();

    AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList);

    File saveAsPNG(String savePath, Report report);

}
