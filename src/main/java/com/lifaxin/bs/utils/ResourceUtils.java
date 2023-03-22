package com.lifaxin.bs.utils;

/**
 * 资源管理工具
 *
 * @author FaXin.Li
 * @date 2023/3/15 18:31
 */
public class ResourceUtils {

    private static final String IMAGE_HOME = "/com/lifaxin/bs/images/";


    public static ResourceUtils instance = new ResourceUtils();
    private ResourceUtils(){

    }

    /**
     * 获取图片地址
     *
     * @param key
     * @return
     */
    public String getImage(String key) {
        return getClass().getResource(IMAGE_HOME + key).toString();
    }
}
