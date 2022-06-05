package cn.fastword.picture.basicDraw;

import cn.fastword.picture.handler.DefaultXYDatasetHandler;
import cn.fastword.picture.model.BasicDataset;
import cn.fastword.picture.model.Picture;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

/**
 * @author wanghe
 * 折线图
 */
public class DrawBasicLinePicture extends AbstractDrawBasicPicture {
    /**
     * 是否显示数值
     */
    private boolean showLabels = true;
    /**
     * 是否显示标签
     */
    private boolean showShapeVisible = true;

    public DrawBasicLinePicture(String title, String XAxisLabel, String YAxisLabel, Picture picture) {
        super(title, XAxisLabel, YAxisLabel, picture);
    }

    @Override
    public JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createLineChart(this.title, this.XAxisLabel, this.YAxisLabel, (CategoryDataset) this.dataset,
                PlotOrientation.VERTICAL, true, true, false);
        super.setLineRender(chart.getCategoryPlot(), this.showLabels, this.showShapeVisible);
        chart.setTextAntiAlias(true);
        return chart;
    }

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList) {
        return this.addDefaultDataSet(dataSetList, new DefaultXYDatasetHandler(), DefaultCategoryDataset.class);
    }

    public DrawBasicLinePicture showLabels(boolean showLabels) {
        this.showLabels = showLabels;
        return this;
    }

    public DrawBasicLinePicture showShapeVisible(boolean showShapeVisible) {
        this.showShapeVisible = showShapeVisible;
        return this;
    }
}
