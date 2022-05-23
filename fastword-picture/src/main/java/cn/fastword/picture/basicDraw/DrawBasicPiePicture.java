package cn.fastword.picture.basicDraw;

import cn.fastword.picture.handler.DefaultCriteriaDatasetHandler;
import cn.fastword.picture.model.BasicDataset;
import cn.fastword.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.List;

/**
 * @author wanghe
 * 饼图
 */
public class DrawBasicPiePicture extends AbstractDrawBasicPicture {

    public DrawBasicPiePicture(String title, Picture picture) {
        super(title, null, null, picture);
    }

    @Override
    public JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createPieChart(this.title, (DefaultPieDataset) this.dataset);
        super.setPieRender(chart.getPlot());
        return chart;
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultCriteriaDatasetHandler(), DefaultPieDataset.class);
    }
}
