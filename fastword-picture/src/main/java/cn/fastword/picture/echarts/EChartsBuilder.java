package cn.fastword.picture.echarts;

import cn.fastword.picture.file.FileUniversalAvailable;
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
public class EChartsBuilder {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String phantomExePath = null;

    protected final String PICTURE_TEMP_PATH = "临时图片";

    protected final String JSON_TEMP_PATH = "临时数据";

    public EChartsBuilder(String phantomExePath) {
        this.phantomExePath = phantomExePath;
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
        return System.getProperty("user.home").concat(this.createPathBuilder("fastword", relativePath).concat(File.separator));
    }


    /**
     * 获取Jar所在资源目录
     *
     * @param filePath 查找的文件名称路径
     * @return 文件
     */
    protected String getPhantomJs(String filePath) throws Exception {
        return new File(Thread.currentThread().getContextClassLoader()
                .getResource("").getPath().concat(this.createPathBuilder("bin", "echarts", filePath))).getAbsolutePath();
    }

    /**
     * 生成图片
     *
     * @param options 标准生成Json
     * @return 文件路径
     */
    public String createChart(String options) throws Exception {
        String generatorJsonFile = this.createJsonFile(options);
        String fileName = this.getBasicRootPath(this.PICTURE_TEMP_PATH).concat(this.getUUID().concat(".png"));
        try {
            FileUniversalAvailable.createNewFile(new File(fileName));
            String exec = this.phantomExePath.concat(" ") +
                    this.getPhantomJs(this.createPathBuilder("core.js ") + " -infile " + generatorJsonFile + " -outfile " + fileName);
            logger.info("<== Preparing: {}", exec);
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
     * @param options 待生成处理Json串
     * @return 文件路径
     */
    private String createJsonFile(String options) throws IOException {
        File fileName = new File(this.getBasicRootPath(this.JSON_TEMP_PATH), this.getUUID().concat(".json"));
        try {
            if (StringUtils.isEmpty(options)) {
                throw new RuntimeException("options图表数据为空,请检查参数，本次进程终止...");
            }
            FileUniversalAvailable.createNewFile(fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(options);
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
     * @param content 文件夹名称数组
     * @return 文件路径
     */
    private String createPathBuilder(String... content) {
        StringBuilder builder = new StringBuilder(64);
        for (String s : content) {
            builder.append(File.separator).append(s);
        }
        return builder.toString();
    }
}
