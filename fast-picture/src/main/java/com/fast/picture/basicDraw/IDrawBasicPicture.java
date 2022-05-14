package com.fast.picture.basicDraw;

import com.fast.picture.enums.Report;
import com.fast.picture.handler.IDatasetHandler;
import com.fast.picture.model.BasicDataset;
import org.jfree.chart.JFreeChart;

import java.io.File;
import java.util.List;

public interface IDrawBasicPicture {

    JFreeChart createChart();

    AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList, IDatasetHandler handler);

    File saveAsPNG(String savePath, Report report);

}
