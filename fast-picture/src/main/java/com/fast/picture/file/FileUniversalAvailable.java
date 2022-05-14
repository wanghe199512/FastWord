package com.fast.picture.file;

import com.common.utils.DateUtils;
import com.fast.picture.enums.Report;
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
     * 报告名称
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
     */
    public File getFileAvailable() {
        if (StringUtils.isEmpty(this.outputPath)) {
            throw new RuntimeException("图像生成父目录层级结构不能为空,本次进程终止...");
        }
        File saveFile = new File(this.getFileRootAvailablePath(), this.report.getName().equals("日报") ? DateUtils.getCurrentDate() : DateUtils.getCurrentMonth()
                .concat(File.separator));
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        return saveFile;
    }

    /**
     * 删除过期文件
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
     */
    public String getFileRootAvailablePath() {
        return this.outputPath.concat(this.report.getName()).concat(File.separator);
    }

    public String getRoot() {
        return outputPath;
    }

    public FileUniversalAvailable setRoot(String root) {
        this.outputPath = root;
        return this;
    }
}
