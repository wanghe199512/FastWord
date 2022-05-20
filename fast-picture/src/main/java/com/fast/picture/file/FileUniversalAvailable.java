package com.fast.picture.file;

import com.fast.picture.enums.Report;
import com.fast.picture.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 基础文件操作
 *
 * @author wanghe
 */
public class FileUniversalAvailable {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 报告存储类型
     */
    private Report report;
    /**
     * 一级目录
     */
    private String outputPath;

    public FileUniversalAvailable() {
    }

    public FileUniversalAvailable(String outputPath, Report report) {
        this.outputPath = outputPath;
        this.report = report;
    }

    /**
     * 获取可用图片保存路径(example:线路/行别/1.png)
     *
     * @return 图片全路径
     */
    public File getFileAvailable() {
        if (StringUtils.isEmpty(this.outputPath) || this.report == null) {
            throw new RuntimeException("图像生成父目录层级结构或报告存储类型[Report]不能为空,本次进程终止...");
        }
        String reportName = this.report.getName();
        File saveFile = new File(this.getFileRootAvailablePath(), (reportName.equals("基础日报") || reportName.equals("基础周报") ?
                DateUtils.getLocalDate() : (reportName.equals("基础月报") ? DateUtils.getLocalMonth() : DateUtils.getLocalYear())).concat(File.separator));
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        return saveFile;
    }

    /**
     * 删除过期文件
     *
     * @param fileRootAvailablePath 删除的根路径
     */
    public void deleteUnAvailableFile(String fileRootAvailablePath) {
        File[] listFiles = new File(fileRootAvailablePath).listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {//删除子文件
                deleteSimpleFile(listFiles[i].getAbsolutePath());
            } else { //删除子目录
                deleteUnAvailableFile(listFiles[i].getAbsolutePath());
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param availableName 删除的文件
     */
    public void deleteSimpleFile(String availableName) {
        File file = new File(availableName);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    public File getFileAvailable(String fileName) {
        return new File(this.getFileAvailable(), fileName);
    }

    /**
     * 获取报告根路径
     *
     * @return 报告所在完整路径
     */
    public String getFileRootAvailablePath() {
        return this.outputPath.concat(this.report.getName()).concat(File.separator);
    }

}
