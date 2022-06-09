import cn.fastword.picture.basicDraw.DrawBasicBarPicture;
import cn.fastword.picture.basicDraw.DrawBasicLinePicture;
import cn.fastword.picture.basicDraw.DrawBasicPiePicture;
import cn.fastword.picture.basicDraw.DrawBasicScatterPicture;
import cn.fastword.picture.enums.Report;
import cn.fastword.picture.model.DefaultCriteriaDataset;
import cn.fastword.picture.model.DefaultXYDataset;
import cn.fastword.picture.model.Picture;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PictureTest {

    @Test
    public void DrawBasicLinePicture1() {
        List<DefaultXYDataset> list = new ArrayList<>();
        String[] legendList = new String[]{"TQI值", "平均速度"};
        List<LinkedList<Integer>> aaList = new ArrayList<>();
        LinkedList<Integer> collect1 = Stream.of(new Integer[]{2, 3, 4, 9, 6}).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> collect2 = Stream.of(new Integer[]{3, 5, 4, 11, 6, 5, 2, 7}).collect(Collectors.toCollection(LinkedList::new));
        aaList.add(collect1);
        aaList.add(collect2);
        DefaultXYDataset defaultDataSet = new DefaultXYDataset(legendList,
                aaList, Arrays.asList(new String[]{"2021-06-23", "2021-06-24", "2021-06-25", "2021-06-26", "2021-06-27", "2021-06-28", "2021-06-29", "2021-06-30", "2021-06-29", "2021-06-30"}));
        list.add(defaultDataSet);
        File file = new DrawBasicLinePicture("2022年上半年销售额", "日期", "单位:(万元)",
                new Picture("2022年上半年销售额.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }


    @Test
    public void DrawBasicLinePicture2() {
        List<DefaultXYDataset> list = new ArrayList<>();
        String[] legendList = new String[]{"TQI值", "平均速度"};
        List<LinkedList<Integer>> aaList = new ArrayList<>();
        LinkedList<Integer> collect1 = Stream.of(new Integer[]{2, 3, 4, 9, 6}).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> collect2 = Stream.of(new Integer[]{3, 5, 4, 11, 6, 5, 2, 7}).collect(Collectors.toCollection(LinkedList::new));
        aaList.add(collect1);
        aaList.add(collect2);
        DefaultXYDataset defaultDataSet = new DefaultXYDataset(legendList,
                aaList, Arrays.asList(new String[]{"2021-06-23", "2021-06-24", "2021-06-25", "2021-06-26", "2021-06-27", "2021-06-28", "2021-06-29", "2021-06-30", "2021-06-29", "2021-06-30"}));
        list.add(defaultDataSet);
        File file = new DrawBasicLinePicture("2022年上半年销售额", "日期", "单位:(万元)",
                new Picture("2022年上半年销售额.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void DrawBasicLinePicture() {
        List<DefaultXYDataset> list = new ArrayList<>();
        LinkedList<Integer> collect1 = Stream.of(new Integer[]{2, 3, 4}).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> collect2 = Stream.of(new Integer[]{2, 8, 4, 20}).collect(Collectors.toCollection(LinkedList::new));
        DefaultXYDataset defaultDataSet = new DefaultXYDataset("折线图", collect1, Arrays.asList(new String[]{"水果", "蔬菜", "鸡蛋"}));
        DefaultXYDataset defaultDataSet2 = new DefaultXYDataset("折图", collect2, Arrays.asList(new String[]{"水果", "蔬菜", "鸡蛋", "香烟"}));
        list.add(defaultDataSet);
        list.add(defaultDataSet2);
        File file = new DrawBasicLinePicture("测试", "测试", "测试",
                new Picture("测试折线图.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void DrawBasicBarPicture() {
        List<DefaultXYDataset> list = new ArrayList<>();
        LinkedList<Integer> collect1 = Stream.of(new Integer[]{2, 3, 4}).collect(Collectors.toCollection(LinkedList::new));
        DefaultXYDataset defaultDataSet = new DefaultXYDataset("柱状图", collect1, Arrays.asList(new String[]{"水果", "蔬菜", "鸡蛋"}));
        list.add(defaultDataSet);
        File file = new DrawBasicBarPicture("测试", "测试", "测试",
                new Picture("测试柱状图.png")).addDefaultDataSet(list).saveAsPNG("d://临时图片/", Report.基础年报);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void DrawBasicScatterPicture() {
        List<DefaultCriteriaDataset> list = new ArrayList<>();
        DefaultCriteriaDataset defaultDataSet = new DefaultCriteriaDataset("水果", 30, 20);
        DefaultCriteriaDataset defaultDataSet2 = new DefaultCriteriaDataset("水果", 234, 45);
        list.add(defaultDataSet);
        DefaultCriteriaDataset defaultDataSet3 = new DefaultCriteriaDataset("水果", 13, 43);
        list.add(defaultDataSet2);
        DefaultCriteriaDataset defaultDataSet4 = new DefaultCriteriaDataset("水果", 534, 256);
        list.add(defaultDataSet3);
        list.add(defaultDataSet4);
        DefaultCriteriaDataset defaultDataSet5= new DefaultCriteriaDataset("水果1", 537, 256);
        list.add(defaultDataSet5);
        DefaultCriteriaDataset defaultDataSet6 = new DefaultCriteriaDataset("水果1", 1094, 256);
        list.add(defaultDataSet6);

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
