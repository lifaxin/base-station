package com.lifaxin.bs.repository.entity;

import lombok.Data;

/**
 * 插件实体类
 *
 * @author FaXin.Li
 * @date 2023/3/23 15:40
 */
@Data
public class PluginEntity {

    private String id ;
    /** 插件类别 */
    private String pluginCategory ;
    /** 插件CODE */
    private String pluginCode ;
    /** 插件名称 */
    private String pluginName ;
    /** 插件版本 */
    private String pluginVersion ;
    /** 插件版本码;如果更新，需要配置比上版本+1 */
    private Integer pluginVersionCode ;
    /** 插件描述 */
    private String pluginDescription ;
    /** 插件下载地址 */
    private String pluginAddr ;
    /** 创建人 */
}
