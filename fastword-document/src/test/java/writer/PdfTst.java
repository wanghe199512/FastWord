package writer;

import cn.fastword.word.PdfFileWriter;
import cn.fastword.word.handller.DefaultAnnotationTableHandler;
import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfTst {
    @Test
    public void create() throws IOException, DocumentException {
        PdfFileWriter writer = new PdfFileWriter("分析报告","d://aa");
        writer.addHeader("11111111111111111111111111");
        writer.addParagraphTableRows(this.getBeanList(),User.class,"111111111111111");
        String documentFile = writer.getDocumentFile();
        System.out.println(documentFile);
    }


    /**
     * 使用注解处理器
     * @return
     */
    private DefaultAnnotationTableHandler useDefaultAnnotationTableHandler() {
        List<User> childBeans = new ArrayList<>();
        User user = new User("王贺", "北京昌平", "27", "18810243420", "辣鸡大学");
        User user2 = new User("张三", "北京昌平", "15278987000", "辣鸡大学");
        childBeans.add(user);
        childBeans.add(user2);
        return new DefaultAnnotationTableHandler(childBeans,User.class);
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
