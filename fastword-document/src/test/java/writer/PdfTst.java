package writer;

import cn.fastword.word.PdfFileWriter;
import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.IOException;

public class PdfTst {
    @Test
    public void create() throws IOException, DocumentException {
        PdfFileWriter writer = new PdfFileWriter("分析报告","d://aa");
        writer.addHeader("11111111111111111111111111");
        writer.getDocumentFile();
    }
}
