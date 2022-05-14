package writer;

import com.fast.word.AbstractIBasicWord;
import com.fast.word.beans.TableBeans;
import com.fast.word.handller.DefaultTableBeansHandler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 病害信息动态分析报告
 *
 * @author wanghe
 */
public class Word extends AbstractIBasicWord {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void reportWriter() {
        // 真正的报告处理
        this.addHeader("动态分析报告", "2022年04月30日", "签发人：王贺");

        this.addParagraphRows("一、信息描述（人工描述）", "2022年XX月XX日京广上行K689+338车载垂加二级重复超限、峰值0.18。",
                "二、设备概况（人工描述）", "该处属于有砟轨道，钢轨P60，扣件XX ，位于郑州东站9道商鼎路立交路桥结合部附近。");

        /*this.addParagraphPictureRows(new File("D:\\RailReport\\铁科院日报\\2022-05-08\\京广\\上\\2.png"), "四、前期动态信息分析",
                "（一）综合检测车信息", "1、近一个月动检数据对比");*/

        this.addParagraphRows("2、近两次波形图对比分析");

       // this.addParagraphTableRows(new DefaultTableBeansHandler(this.getTableBeans()), "3、TQI对比分析");

        this.addParagraphRows("（四）人工添乘情况", " 自2022年X月X日至今该处无人工体感晃车信息。");
        this.addParagraphRows("（五）、其他情况", "  1、会车情况", "调看轨道电路，GXX车次与GXX车次在XX:XX时间KXXX+XXX里程附近有会车");
        this.addParagraphRows("  2、风速情况", "查询信息里程最近位置的风速监测点，XX:XX实时风速XXm/s（X级风）");
        this.addParagraphRows(" （六）、初步结论", "经以上信息综合分析，初步判断该处病害为高低、轨向、三角坑、水平、轨距不良引起的。");

    }

    private TableBeans getTableBeans() {
        List<List<String>> childBeans = new ArrayList<>();
        childBeans.add(Arrays.asList(new String[]{"京广高铁", "689.34", "33", "55", "0", "0", "12", "3", "2022-04-19", "09:12:00", "0", "20480", "0"}));
        TableBeans bean = new TableBeans(Arrays.asList(new String[]{"线名", "行别", "里程", "速度", "水加", "水加级别", "垂加", "垂加级别", "日期", "时间", "车型", "机车号", "车次"}), childBeans);
        return bean;
    }

    @Test
    public void genWord() {
        String fileName = new Word().getWord2007("病害信息动态分析报告", "d://aa");
        logger.info(" ===>{}", fileName);
    }
}
