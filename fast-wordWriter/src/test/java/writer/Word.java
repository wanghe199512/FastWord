package writer;

import com.fast.word.AbstractIBasicWord;
import com.fast.word.WordFile07Writer;
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
public class Word {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public WordFile07Writer reportWriter() {
        WordFile07Writer writer = new WordFile07Writer();
        // 真正的报告处理
        writer.addHeader("fast-word(快速Word文档构建)", "2022年04月30日", "签发人：王贺");

        writer.addParagraphRows("为什么会出现fast-word?", "文档的导入导出，不管是在ERP，SASS或者诸如一切的其他管理系统，都是必不可少的，而在我实际开发的过程中涉及到的Word是比较多的，" +
                "我在网上查阅了很多资料，关于Word导出几乎都是模板替换的方式，在word xml中打标签无疑是一件痛苦的事情。于是fast-word应运而生，我给它起名叫“ fast-word”旨在快速，易用，高效的解决我们的问题，节省我们宝贵的时间。"
        );

        writer.addParagraphRows("fast-word的优势在哪里？", "相对于原生poi，我们更简单，同时支持了通过数据生成图片。相对于打标签模板替换的方式，我们更高效，fast-word可以让您只关注业务，您给我们业务数据，" +
                "只需要三步我们帮您实现从0到1的word生成  快速上手 ，其中包含了图表绘制，表格绘制，文本添加，导出word四大模块。"
        );

        /*writer.addParagraphPictureRows(new File("D:\\2.png"), "四、啦啦啦啦啦啦");*/
        writer.addParagraphRows("fast-word当前版本是什么？");
        writer.addParagraphTableRows(new DefaultTableBeansHandler(this.getTableBeans()), "我是表格标题独占一行");
        return writer;
    }

    private TableBeans getTableBeans() {
        List<List<String>> childBeans = new ArrayList<>();
        childBeans.add(Arrays.asList(new String[]{"王贺", "男", "27", "山西大同", "北京昌平"}));
        TableBeans bean = new TableBeans(Arrays.asList(new String[]{"姓名", "性别", "年龄", "户籍地", "居住地"}), childBeans);
        return bean;
    }

    @Test
    public void genWord() {
        String fileName = new Word().reportWriter().getDocumentFile("分析报告", "d://aa");
        logger.info(" ===>{}", fileName);

    }
}
