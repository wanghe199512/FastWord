import cn.fastword.picture.echarts.EChartsBuilder;
import cn.fastword.picture.enums.Report;
import cn.fastword.picture.model.DefaultEChartsDataset;
import cn.fastword.picture.model.Picture;
import org.junit.Test;

public class PictureTest {

    @Test
    public void DrawBasicLinePicture1() throws Exception {
        DefaultEChartsDataset defaultDataSet = new DefaultEChartsDataset(new String[]{"平均速度","TQI"},
                new Integer[][]{{6, 43, 10, 24},{1, 4, 10, 27}}, new String[]{"2021-06-23", "2021-06-24", "2021-06-25", "2021-06-26"});
        EChartsBuilder eChartsBuilder = new EChartsBuilder("D:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe",
                "D:\\bin\\echarts\\core.js", defaultDataSet, new Picture("qq", "主标题", "副标题"));
        eChartsBuilder.saveAsPNG("", Report.基础日报);
    }
}
