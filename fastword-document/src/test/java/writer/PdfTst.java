package writer;

import cn.fastword.word.PdfFileWriter;
import org.junit.Test;

public class PdfTst {
    @Test
    public void create(){
        PdfFileWriter writer = new PdfFileWriter("分析报告","d://aa");
       writer.addHeader("11111111111111111111111111");
        writer.getDocumentFile();
    }
}
