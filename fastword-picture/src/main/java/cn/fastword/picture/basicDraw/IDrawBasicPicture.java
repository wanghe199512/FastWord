package cn.fastword.picture.basicDraw;

import cn.fastword.picture.enums.Report;
import cn.fastword.picture.model.BasicDataset;
import org.jfree.chart.JFreeChart;

import java.io.File;
import java.util.List;

public interface IDrawBasicPicture {

    JFreeChart createChart();

    AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList);

    File saveAsPNG(String savePath, Report report);

}
