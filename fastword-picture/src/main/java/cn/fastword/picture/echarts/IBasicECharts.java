package cn.fastword.picture.echarts;

import cn.fastword.picture.enums.Report;
import org.jfree.chart.JFreeChart;

import java.io.File;
import java.util.List;

public interface IBasicECharts {

    JFreeChart createChart();

    AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList);

    File saveAsPNG(String savePath, Report report);

}
