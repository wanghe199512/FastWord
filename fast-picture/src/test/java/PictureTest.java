import com.fast.picture.basicDraw.DrawBasicBarPicture;
import com.fast.picture.basicDraw.DrawBasicLinePicture;
import com.fast.picture.basicDraw.DrawBasicPiePicture;
import com.fast.picture.basicDraw.DrawBasicScatterPicture;
import com.fast.picture.enums.Report;
import com.fast.picture.model.DefaultXYDataset;
import com.fast.picture.model.DefaultCriteriaDataset;
import com.fast.picture.model.Picture;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PictureTest {
    @Test
    public void DrawBasicLinePicture() {
        List<DefaultXYDataset> list = new ArrayList<>();
        DefaultXYDataset defaultDataSet = new DefaultXYDataset("折线图",
                Arrays.asList(new Integer[]{2, 3, 4}), Arrays.asList(new String[]{"水果", "蔬菜", "鸡蛋"}));
        list.add(defaultDataSet);
        File file = new DrawBasicLinePicture("测试", "测试", "测试",
                new Picture("测试折线图.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void DrawBasicBarPicture() {
        List<DefaultXYDataset> list = new ArrayList<>();
        DefaultXYDataset defaultDataSet = new DefaultXYDataset("柱状图",
                Arrays.asList(new Integer[]{2, 3, 4}), Arrays.asList(new String[]{"水果", "蔬菜", "鸡蛋"}));
        list.add(defaultDataSet);
        File file = new DrawBasicBarPicture("测试", "测试", "测试",
                new Picture("测试柱状图.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void DrawBasicScatterPicture() {
        List resultList = new ArrayList();
        resultList.add(Arrays.asList(new Double[]{5D, 8D}));
        resultList.add(Arrays.asList(new Double[]{2D, 3D}));
        List<DefaultXYDataset> list = new ArrayList<>();
        DefaultXYDataset defaultDataSet = new DefaultXYDataset("散点图",
                resultList, Arrays.asList(new String[]{"水果", "蔬菜"}));
        list.add(defaultDataSet);
        File file = new DrawBasicScatterPicture("测试", "测试", "测试",
                new Picture("测试散点图.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void DrawBasicPiePicture() {
        List<DefaultCriteriaDataset> list = new ArrayList<>();
        DefaultCriteriaDataset defaultDataSet = new DefaultCriteriaDataset("水果", 30);
        DefaultCriteriaDataset defaultDataSet2 = new DefaultCriteriaDataset("蔬菜", 60);
        list.add(defaultDataSet);
        list.add(defaultDataSet2);
        File file = new DrawBasicPiePicture("各农作物占比",
                new Picture("测试饼图.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }
}
