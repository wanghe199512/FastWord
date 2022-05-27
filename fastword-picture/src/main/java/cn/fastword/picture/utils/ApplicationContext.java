package cn.fastword.picture.utils;

import java.io.File;

/**
 * 上下文对象
 *
 * @author wanghe
 */
public class ApplicationContext {

    private String applicationContext = "fastword";

    /**
     * 设置上下文
     *
     * @param context
     */
    protected void setApplicationContext(String context) {
        this.applicationContext = context;
    }

    /**
     * 获取图片生成上下文对象
     *
     * @return 上下文路径
     */
    protected String getApplicationContext() {
        return System.getProperty("user.home").concat(File.separator).concat(this.applicationContext).concat(File.separator);
    }

}
