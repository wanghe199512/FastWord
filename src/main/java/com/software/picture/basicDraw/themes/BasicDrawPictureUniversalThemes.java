package com.software.picture.basicDraw.themes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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

    private final static Font font = new Font("黑体", Font.PLAIN, 14);
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
        pictureTheme.setExtraLargeFont(font);
        // 设置图例的字体
        pictureTheme.setRegularFont(font);
        // 设置轴向的字体
        pictureTheme.setLargeFont(font);
        pictureTheme.setSmallFont(font);
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
     * 设置显示数据标签
     */
    protected void setLabels(AbstractCategoryItemRenderer renderer) {
        renderer.setStroke(new BasicStroke(1.5F));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator(StandardCategoryItemLabelGenerator.DEFAULT_LABEL_FORMAT_STRING, NumberFormat.getInstance()));
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BOTTOM_CENTER));
    }

    /**
     * 设置折线显示形状
     */
    protected void setShapesVisible(AbstractCategoryItemRenderer abstractRenderer) {
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) abstractRenderer;
        renderer.setBaseShapesVisible(true);// 数据点绘制形状
    }

    protected void setShapesVisibleLabel(AbstractCategoryItemRenderer abstractRenderer) {
        this.setLabels(abstractRenderer);
        this.setShapesVisible(abstractRenderer);
    }

}
