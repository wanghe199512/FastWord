package cn.fastword.picture.echarts;

import cn.fastword.picture.enums.Report;
import cn.fastword.picture.file.FileAvailable;
import cn.fastword.picture.model.DefaultEChartsDataset;
import cn.fastword.picture.model.Picture;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 图片生成保存核心
 *
 * @author wanghe
 */
public class EChartsBuilder extends AbstractBasicECharts {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String phantomPath = null;

    private String phantomJSPath = null;

    protected String options = "";

    protected final String PICTURE_TEMP_PATH = "临时图片";

    protected final String JSON_TEMP_PATH = "临时数据";

    public EChartsBuilder(String phantomPath, String phantomJSPath, String options) {
        this(phantomPath, phantomJSPath, null, null);
        this.options = options;
    }

    public EChartsBuilder(String phantomPath, String phantomJSPath, DefaultEChartsDataset dataset, Picture picture) {
        super(dataset, picture);
        if (StringUtils.isEmpty(phantomPath) || StringUtils.isEmpty(phantomJSPath)) {
            throw new RuntimeException("本环境依赖于第三方PhantomJS，务必传入PhantomJS可用的文件路径...");
        }
        this.phantomPath = phantomPath;
        this.phantomJSPath = phantomJSPath;
    }

    /**
     * 获取标准路径(均保存在用户目录下)
     *
     * @param relativePath 相对子目录路径
     * @return 临时存储路径
     */
    private String getBasicRootPath(String relativePath) {
        if (StringUtils.isEmpty(relativePath)) {
            throw new RuntimeException("Please use relativePath,but it isEmpty...");
        }
        return this.createPathBuilder(this.getApplicationContext(), relativePath).concat(File.separator);
    }


    /**
     * 生成图片
     *
     * @return 文件路径
     */
    @Override
    public File saveAsPNG(String savePath, Report report) throws Exception {
        String generatorJsonFile = this.createJsonFile(this.options.isEmpty() ? this.getOptions(Line.class).toString() : this.options);  // 如果options为传入，那么直接画图
        File fileName = new File(this.getBasicRootPath(this.PICTURE_TEMP_PATH).concat(this.getUUID().concat(".png")));
        try {
            FileAvailable.createNewFile(fileName);
            String exec = this.phantomPath.concat(" ") + this.phantomJSPath + " -infile " + generatorJsonFile + " -outfile " + fileName;
            logger.info("<== Preparing: {}", exec);
            System.out.println(exec);
            Process process = Runtime.getRuntime().exec(exec);
            process.waitFor(4000, TimeUnit.SECONDS); // 如果四秒未处理成功就停止
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            logger.info("==> Preparing:  {}", reader.lines().collect(Collectors.toList()).toString());
            process.destroy();  // 销毁进程
            reader.close();
        } catch (Exception e) {
            throw new IOException("生成图片失败，本次进程终止...", e);
        }
        return fileName;
    }


    /**
     * 创建生成器Json文件
     *
     * @param option 待生成处理Json串
     * @return 文件路径
     */
    private String createJsonFile(String option) throws IOException {
        File fileName = new File(this.getBasicRootPath(this.JSON_TEMP_PATH), this.getUUID().concat(".json"));
        try {
            if (StringUtils.isEmpty(option)) {
                throw new RuntimeException("options图表数据为空,请检查参数，本次进程终止...");
            }
            FileAvailable.createNewFile(fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(option);
            out.flush();
            out.close();
            logger.info("==> Preparing: {}", fileName);
        } catch (IOException e) {
            throw new IOException("创建生成器Json文件失败，本次进程终止...", e);
        }
        return fileName.getAbsolutePath();
    }

    /**
     * 获取文件随机名称
     *
     * @return 8位随机数
     */
    private String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 文件路径批处理
     *
     * @param dirArr 文件夹名称数组
     * @return 文件路径
     */
    private String createPathBuilder(String... dirArr) {
        StringBuilder builder = new StringBuilder(64);
        for (String dir : dirArr) {
            builder.append(File.separator).append(dir);
        }
        return builder.toString();
    }
}
