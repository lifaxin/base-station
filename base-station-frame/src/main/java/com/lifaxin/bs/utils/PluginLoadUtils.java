package com.lifaxin.bs.utils;

import com.lifaxin.bs.core.exception.ExceptionCodeEnum;
import com.lifaxin.bs.core.exception.PluginLoadException;
import com.lifaxin.bs.domain.PluginEntity;
import com.lifaxin.bs.plugin.PluginService;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * 插件加载类
 *
 * @author FaXin.Li
 * @date 2023/3/16 13:45
 */
public class PluginLoadUtils {

    public static PluginLoadUtils instance = new PluginLoadUtils();

    private PluginLoadUtils() {
    }

    /**
     * 加载插件类的Class Loader
     *
     * @param jar
     * @return
     */
    private static URLClassLoader getUrlClassLoader(String jar) {
        // 加载Jar包
        File jarFile = new File(jar);
        if (!jarFile.exists()) {
            throw new PluginLoadException(ExceptionCodeEnum.JAR_LOAD_EXCEPTION);
        }
        // 获取Jar包的Class Loader
        URLClassLoader loader = null;
        try {
            loader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()}, ClassLoader.getSystemClassLoader());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return loader;
    }




    /**
     * 加载本地所有的jar
     *
     * @param path
     */
    public List<PluginEntity> loadAllJarPlugin(String path) {
        List<PluginEntity> pluginList = new ArrayList<>();
        // 扫描文件目录下所有Jar包
        File[] jarFiles = new File(path).listFiles((dir, name) -> StringUtils.endsWith(name, ".jar"));
        // 空数据处理
        if (Objects.isNull(jarFiles)) {
            return pluginList;
        }
        // 获取插件信息
        Arrays.asList(jarFiles).forEach(file -> {
            // 查询Jar包内子类
            Optional.of(scanSubClass(file)).ifPresent(plugins -> {
                plugins.forEach(item -> {
                    for (int i = 0; i < 3; i++){
                        PluginService pluginService = loadPlugin(file, item);
                        PluginEntity plugin = new PluginEntity(getUrlClassLoader(file.getAbsoluteFile()), pluginService);
                        pluginList.add(plugin);
                    }
                });
            });
        });
        return pluginList;
    }

    /**
     * 扫描获取插件入口子类
     *
     * @return 插件入口子类集合
     */
    private List<String> scanSubClass(File jar) {
        // 扫描到的子类集合
        List<String> subClassList = new ArrayList<>();
        URLClassLoader loader = getUrlClassLoader(jar);
        // 扫描jar包中插件入口
        try (ScanResult scanResult = new ClassGraph().enableClassInfo().addClassLoader(loader).scan()) {
            for (ClassInfo classInfo : scanResult.getClassesImplementing(PluginService.class.getName())) {
                subClassList.add(classInfo.getName());
            }
        }
        return subClassList;
    }

    /**
     * 获取ClassLoader
     *
     * @param jarFile jar 文件地址
     * @return URLClassLoader.class
     */
    public static URLClassLoader getUrlClassLoader(File jarFile) {
        // 获取Jar包的Class Loader
        URLClassLoader loader = null;
        try {
            loader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()}, ClassLoader.getSystemClassLoader());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return loader;
    }

    /**
     * 加载插件
     *
     * @param jar               jar文件地址
     * @param pluginService     搜寻的类
     * @return 搜寻的类实例
     */
    private PluginService loadPlugin(File jar, String pluginService) {
        URLClassLoader loader;
        try {
            loader = getUrlClassLoader(jar);
            // 加载类
            Class<?> clazz = loader.loadClass(pluginService);
            // 实例化类
            return (PluginService) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new PluginLoadException(ExceptionCodeEnum.CLASS_LOAD_EXCEPTION);
        }
    }
}
