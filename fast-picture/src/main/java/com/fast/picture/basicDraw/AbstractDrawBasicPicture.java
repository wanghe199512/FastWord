package com.fast.picture.basicDraw;

import com.fast.picture.basicDraw.themes.BasicDrawPictureUniversalThemes;
import com.fast.picture.enums.Report;
import com.fast.picture.file.FileUniversalAvailable;
import com.fast.picture.handler.IDatasetHandler;
import com.fast.picture.model.BasicDataset;
import com.fast.picture.model.Picture;
import org.apache.commons.collections.CollectionUtils;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author wanghe
 * 图片生成抽象类
 */
public abstract class AbstractDrawBasicPicture extends BasicDrawPictureUniversalThemes implements IDrawBasicPicture {
    /**
     * 图表标题
     */
    protected String defaultTitle;
    /**
     * 图片宽度
     */
    protected int defaultWidth;
    /**
     * 图片高度
     */
    protected int defaultHeight;
    /**
     * x轴显示名称
     */
    protected String XAxisLabel;
    /**
     * y轴显示名称
     */
    protected String YAxisLabel;
    /**
     * 基础信息(文件名称等)
     */
    protected Picture picture;

    /**
     * 数据集
     */
    protected Dataset dataset;

    public AbstractDrawBasicPicture(String defaultTitle) {
        super(true);
        this.defaultTitle = defaultTitle;
    }

    private AbstractDrawBasicPicture(String defaultTitle, String XAxisLabel, String YAxisLabel) {
        this(defaultTitle);
        this.XAxisLabel = XAxisLabel;
        this.YAxisLabel = YAxisLabel;
    }

    public AbstractDrawBasicPicture(String defaultTitle, String XAxisLabel, String YAxisLabel, Picture picture) {
        this(defaultTitle, XAxisLabel, YAxisLabel);
        this.picture = picture;
        this.setDefaultPictureWidthHeight();
    }

    @Override
    public abstract JFreeChart createChart();

    @Override
    public AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList, IDatasetHandler handler) {
        try {
            if (CollectionUtils.isEmpty(dataSetList)) {
                throw new RuntimeException("默认初始化数据集dataSetList为空，本次进程结束！[处理失败...]");
            }
            this.dataset = handler.addDefaultDataSet(dataSetList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 设置图像宽高
     */
    private void setDefaultPictureWidthHeight() {
        if (this.picture != null) {
            if (this.picture.getDefaultHeight() <= 0 && this.picture.getDefaultWidth() <= 0) {
                throw new RuntimeException("Picture对象 要设置的 图片尺寸宽度或高度不能小于或等于0");
            }
            this.defaultHeight = this.picture.getDefaultHeight();
            this.defaultWidth = this.picture.getDefaultWidth();
        }
    }

    /**
     * 保存图片（根据报告类型，目录结构创建保存）
     */
    @Override
    public File saveAsPNG(String outputRootPath, Report report) {
        File availableFile = new FileUniversalAvailable(outputRootPath, report).getFileAvailable(this.picture.getFileName());
        JFreeChart drawPicture = this.createChart();
        try {
            //  this.setShapesVisibleLabel((AbstractCategoryItemRenderer) drawPicture.getCategoryPlot().getRenderer());  // 导出设置显示数值等样式
            ChartUtilities.saveChartAsPNG(availableFile, drawPicture, this.defaultWidth, this.defaultHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return availableFile;
    }
}
