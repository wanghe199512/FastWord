package writer;

import cn.fastword.word.PdfFileWriter;
import cn.fastword.word.handller.DefaultAnnotationTableHandler;
import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfTst {
    @Test
    public void create() throws IOException, DocumentException {
        PdfFileWriter writer = new PdfFileWriter("分析报告", "d://aa");
        writer.addParagraphRows("为什么会出现fast-word?", "文档的导入导出，不管是在ERP，SASS或者诸如一切的其他管理系统，都是必不可少的，而在我实际开发的过程中涉及到的Word是比较多的，" +
                "我在网上查阅了很多资料，关于Word导出几乎都是模板替换的方式，在word xml中打标签无疑是一件痛苦的事情。于是fast-word应运而生，我给它起名叫“ fast-word”旨在快速，易用，高效的解决我们的问题，节省我们宝贵的时间。");
        writer.addParagraphTableRows(this.getBeanList(), User.class, "我是基于注解实体创建的表格");
        writer.addParagraphRows("为什么会出现fast-word?", "文档的导入导出，不管是在ERP，SASS或者诸如一切的其他管理系统，都是必不可少的，而在我实际开发的过程中涉及到的Word是比较多的，" +
                "我在网上查阅了很多资料，关于Word导出几乎都是模板替换的方式，在word xml中打标签无疑是一件痛苦的事情。于是fast-word应运而生，我给它起名叫“ fast-word”旨在快速，易用，高效的解决我们的问题，节省我们宝贵的时间。");
        writer.addParagraphPictureRows(new File("D:\\报告临时文件\\临时图片存储\\基础日报\\2022-06-02\\TQI趋势变化.png"),"图片演示");
        String documentFile = writer.getDocumentFile("本文档由开源组件fast-word构建");
        System.out.println(documentFile);
    }


    /**
     * 使用注解处理器
     *
     * @return
     */
    private DefaultAnnotationTableHandler useDefaultAnnotationTableHandler() {
        List<User> childBeans = new ArrayList<>();
        User user = new User("王贺", "北京昌平", "27", "18810243420", "辣鸡大学");
        User user2 = new User("张三", "北京昌平", "15278987000", "辣鸡大学");
        childBeans.add(user);
        childBeans.add(user2);
        return new DefaultAnnotationTableHandler(childBeans, User.class);
    }

    private List<User> getBeanList() {
        List<User> childBeans = new ArrayList<>();
        User user = new User("王贺", "北京昌平", "27", "15278987656", "辣鸡大学");
        User user2 = new User("李四", "北京昌平", "15278987000", "辣鸡大学");
        childBeans.add(user);
        childBeans.add(user2);
        return childBeans;
    }
}
