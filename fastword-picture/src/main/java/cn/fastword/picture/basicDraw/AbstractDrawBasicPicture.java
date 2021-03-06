package cn.fastword.picture.basicDraw;

import cn.fastword.picture.basicDraw.themes.BasicDrawPictureUniversalThemes;
import cn.fastword.picture.enums.Report;
import cn.fastword.picture.file.FileUniversalAvailable;
import cn.fastword.picture.handler.IDatasetHandler;
import cn.fastword.picture.model.BasicDataset;
import cn.fastword.picture.model.Picture;
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
    protected String title;
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

    protected AbstractDrawBasicPicture(String title) {
        super(true);
        this.title = title;
    }

    protected AbstractDrawBasicPicture(String title, String XAxisLabel, String YAxisLabel) {
        this(title);
        this.XAxisLabel = XAxisLabel;
        this.YAxisLabel = YAxisLabel;
    }

    protected AbstractDrawBasicPicture(String title, String XAxisLabel, String YAxisLabel, Picture picture) {
        this(title, XAxisLabel, YAxisLabel);
        this.picture = picture;
    }

    @Override
    public abstract JFreeChart createChart();

    @Override
    public abstract AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList);


    /**
     * 添加数据到图表中
     * TODO cls 泛型没有边界，可能会导致异常，待修复
     *
     * @param dataSetList 数据
     * @param handler     指定数据处理器
     * @param cls         必须是图表对象class
     * @return  AbstractDrawBasicPicture
     */
    protected AbstractDrawBasicPicture addDefaultDataSet(List<? extends BasicDataset> dataSetList, IDatasetHandler handler, Class<?> cls) {
        try {
            if (dataSetList == null || dataSetList.size() == 0) {  // TODO 解决部分情况下，jar包冲突
                throw new RuntimeException("默认初始化数据集dataSetList为空，本次进程结束！[处理失败...]");
            }
            this.dataset = handler.handler(dataSetList, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 保存图片（根据报告类型，目录结构创建保存）
     */
    @Override
    public File saveAsPNG(String outputRootPath, Report report) {
        File availableFile = new FileUniversalAvailable(outputRootPath, report).getFileAvailable(this.picture.getFileName());
        JFreeChart drawPicture = this.createChart();
        try {
            ChartUtilities.saveChartAsPNG(availableFile, drawPicture, this.picture.defaultWidth, this.picture.defaultHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return availableFile;
    }
}
