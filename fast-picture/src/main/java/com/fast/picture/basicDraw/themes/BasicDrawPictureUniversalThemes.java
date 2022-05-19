package com.fast.picture.basicDraw.themes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.text.NumberFormat;

/**
 * 图表样式
 *
 * @author wanghe
 */
public class BasicDrawPictureUniversalThemes {

    private final static Font defaultFont = new Font("楷体", Font.BOLD, 16);
    private final static Font headerFont = new Font("黑体", Font.BOLD, 25);
    private final static Color[] colors = {new Color(31, 129, 188), new Color(92, 92, 97), new Color(144, 237, 125), new Color(255, 188, 117),
            new Color(153, 158, 255), new Color(255, 117, 153), new Color(253, 236, 109), new Color(128, 133, 232),
            new Color(158, 90, 102), new Color(255, 204, 102)};// 颜色

    public BasicDrawPictureUniversalThemes(boolean initialize) {
        if (initialize) {
            setDefaultChartTheme();
        }
    }

    protected static void setDefaultChartTheme() {
        // 设置中文主题样式 解决乱码
        StandardChartTheme pictureTheme = new StandardChartTheme("CN");
        // 设置标题字体
        pictureTheme.setExtraLargeFont(headerFont);
        // 设置图例的字体
        pictureTheme.setRegularFont(defaultFont);
        // 设置轴向的字体
        pictureTheme.setLargeFont(defaultFont);
        pictureTheme.setSmallFont(defaultFont);
        pictureTheme.setTitlePaint(new Color(51, 51, 51));
        pictureTheme.setSubtitlePaint(new Color(85, 85, 85));

        pictureTheme.setLegendBackgroundPaint(Color.WHITE);// 设置标注
        pictureTheme.setLegendItemPaint(Color.BLACK);//
        pictureTheme.setChartBackgroundPaint(Color.WHITE);

        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.WHITE};
        // 绘制器颜色源
        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(colors, colors, OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        pictureTheme.setDrawingSupplier(drawingSupplier);

        pictureTheme.setPlotBackgroundPaint(Color.WHITE);// 绘制区域
        pictureTheme.setPlotOutlinePaint(Color.WHITE);// 绘制区域外边框
        pictureTheme.setLabelLinkPaint(new Color(8, 55, 114));// 链接标签颜色
        pictureTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);

        pictureTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
        pictureTheme.setDomainGridlinePaint(new Color(192, 208, 224));// X坐标轴垂直网格颜色
        pictureTheme.setRangeGridlinePaint(new Color(192, 192, 192));// Y坐标轴水平网格颜色
        pictureTheme.setBaselinePaint(Color.WHITE);
        pictureTheme.setCrosshairPaint(Color.BLUE);// 不确定含义
        pictureTheme.setAxisLabelPaint(new Color(51, 51, 51));// 坐标轴标题文字颜色
        pictureTheme.setTickLabelPaint(new Color(67, 67, 72));// 刻度数字
        pictureTheme.setBarPainter(new StandardBarPainter());// 设置柱状图渲染
        pictureTheme.setXYBarPainter(new StandardXYBarPainter());// XYBar 渲染

        pictureTheme.setItemLabelPaint(Color.black);
        pictureTheme.setThermometerPaint(Color.white);// 温度计

        ChartFactory.setChartTheme(pictureTheme);
    }

    /**
     * 设置折线图样式
     *
     * @param plot
     * @param isShowDataLabels 是否显示数据标签
     */
    protected void setLineRender(CategoryPlot plot, boolean isShowDataLabels, boolean isShapesVisible) {
        plot.setNoDataMessage("暂无数据");
        plot.setInsets(new RectangleInsets(10, 10, 0, 10), false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setStroke(new BasicStroke(2.0F));
        if (isShowDataLabels) {
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator(StandardCategoryItemLabelGenerator.DEFAULT_LABEL_FORMAT_STRING, NumberFormat.getInstance()));
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BOTTOM_CENTER));// weizhi
        }
        renderer.setBaseShapesVisible(isShapesVisible);// 数据点绘制形状
        setXAixs(plot);
        setYAixs(plot);
    }

    /**
     * 设置柱状图渲染
     */
    public void setBarRenderer(CategoryPlot plot, boolean isShowDataLabels) {
        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setMaximumBarWidth(0.075);// 设置柱子最大宽度
        if (isShowDataLabels) {
            renderer.setBaseItemLabelsVisible(true);
        }
        setXAixs(plot);
        setYAixs(plot);
    }

    /**
     * 设置堆积柱状图渲染
     *
     * @param plot
     */

    public void setStackBarRender(CategoryPlot plot) {
        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
        StackedBarRenderer renderer = (StackedBarRenderer) plot.getRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        plot.setRenderer(renderer);
        setXAixs(plot);
        setYAixs(plot);
    }


    /**
     * 设置类别图表(CategoryPlot) X坐标轴线条颜色和样式
     *
     * @param
     */
    protected void setXAixs(CategoryPlot plot) {
        Color lineColor = new Color(31, 121, 170);
        plot.getDomainAxis().setAxisLinePaint(lineColor);// X坐标轴颜色
        plot.getDomainAxis().setTickMarkPaint(lineColor);// X坐标轴标记|竖线颜色
    }

    /**
     * 设置类别图表(CategoryPlot) Y坐标轴线条颜色和样式 同时防止数据无法显示
     *
     * @param
     */
    protected void setYAixs(CategoryPlot plot) {
        Color lineColor = new Color(192, 208, 224);
        ValueAxis axis = plot.getRangeAxis();
        axis.setAxisLinePaint(lineColor);// Y坐标轴颜色
        axis.setTickMarkPaint(lineColor);// Y坐标轴标记|竖线颜色
        axis.setAxisLineVisible(false);  // 隐藏Y刻度
        axis.setTickMarksVisible(false);
        plot.setRangeGridlinePaint(new Color(192, 192, 192)); // Y轴网格线条
        plot.setRangeGridlineStroke(new BasicStroke(1));
        plot.getRangeAxis().setUpperMargin(0.1);// 设置顶部Y坐标轴间距,防止数据无法显示
        plot.getRangeAxis().setLowerMargin(0.1);// 设置底部Y坐标轴间距
    }


}
