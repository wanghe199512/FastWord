package com.software.picture.basicDraw;

import com.software.picture.enums.Report;
import com.software.picture.handler.IDatasetHandler;
import com.software.picture.model.BasicDataset;
import org.jfree.chart.JFreeChart;

import java.io.File;
import java.util.List;

public interface IDrawBasicPicture {

    JFreeChart createChart();

    AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList, IDatasetHandler handler);

    File saveAsPNG(String savePath, Report report);

}
