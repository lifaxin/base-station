package com.lifaxin.bs.utils;

import com.lifaxin.bs.common.exception.ExceptionCodeEnum;
import com.lifaxin.bs.common.exception.PluginLoadException;
import com.lifaxin.bs.plugin.PluginService;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 插件加载类
 *
 * @author FaXin.Li
 * @date 2023/3/16 13:45
 */
public class PluginLoadUtils {

    private PluginLoadUtils(){}
    public static PluginLoadUtils instance = new PluginLoadUtils();


    /**
     * 加载本地所有的jar
     *
     * @param path
     */
    public void loadAllJarPlugin(String path) {
        File parentDir = new File(path);
        Optional.ofNullable(parentDir.listFiles((dir, name) -> StringUtils.endsWith(name, ".jar"))).ifPresent(files -> {
            Arrays.asList(files).forEach(file -> {
                Optional.ofNullable(scanSubClass(PluginService.class, file)).ifPresent(plugins -> {
                    plugins.forEach(plugin -> {
                        PluginService pluginService = loadPlugin(file, plugin);
                        System.out.println(pluginService.getName());
                        System.out.println(pluginService.getVersion());
                    });
                });
            });
        });
    }

    /**
     * 根据加载的Jar包，获取Jar包中工具内容
     *
     * @param jar
     */
    public void loadJarPlugin(String jar) {
        Optional.ofNullable(scanSubClass(PluginService.class, jar)).ifPresent(plugins -> {
            plugins.forEach(plugin -> {
                PluginService pluginService = loadPlugin(jar, plugin);
                System.out.println(pluginService.getName());
                System.out.println(pluginService.getVersion());
            });
        });
    }

    /**
     * 扫描获取插件入口子类
     *
     * @return
     */
    public List<String> scanSubClass(Class clazz, File jar) {
        // 扫描到的子类集合
        List<String> subClassList = new ArrayList<>();
        URLClassLoader loader = getUrlClassLoader(jar);
        // 扫描jar包中插件入口
        try (ScanResult scanResult = new ClassGraph().enableClassInfo().addClassLoader(loader).scan()) {
            for (ClassInfo classInfo : scanResult.getClassesImplementing(clazz.getName())) {
                subClassList.add(classInfo.getName());
            }
        }
        return subClassList;
    }

    public List<String> scanSubClass(Class clazz, String jar) {
        // 扫描到的子类集合
        List<String> subClassList = new ArrayList<>();
        URLClassLoader loader = getUrlClassLoader(jar);
        // 扫描jar包中插件入口
        try (ScanResult scanResult = new ClassGraph().enableClassInfo().addClassLoader(loader).scan()) {
            for (ClassInfo classInfo : scanResult.getClassesImplementing(clazz.getName())) {
                subClassList.add(classInfo.getName());
            }
        }
        return subClassList;
    }

    /**
     * 加载插件类的Class Loader
     *
     * @param jar
     * @return
     */
    private static URLClassLoader getUrlClassLoader(String jar){
        // 加载Jar包
        File jarFile = new File(jar);
        if (!jarFile.exists()) {
            throw new PluginLoadException(ExceptionCodeEnum.JAR_LOAD_EXCEPTION);
        }
        // 获取Jar包的Class Loader
        URLClassLoader loader = null;
        try {
            loader = new URLClassLoader(new URL[] {jarFile.toURI().toURL()}, ClassLoader.getSystemClassLoader());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return loader;
    }

    private static URLClassLoader getUrlClassLoader(File jarFile){
        // 获取Jar包的Class Loader
        URLClassLoader loader = null;
        try {
            loader = new URLClassLoader(new URL[] {jarFile.toURI().toURL()}, ClassLoader.getSystemClassLoader());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return loader;
    }


    /**
     * 加载插件
     * @param jar
     * @param pluginService
     * @return
     */
    private PluginService loadPlugin(File jar, String pluginService) {
        URLClassLoader loader = null;
        try {
            loader = getUrlClassLoader(jar);
            // 加载类
            Class<?> clazz = loader.loadClass(pluginService);
            // 实例化类
            return (PluginService)clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new PluginLoadException(ExceptionCodeEnum.CLASS_LOAD_EXCEPTION);
        }
    }

    public PluginService loadPlugin(String jar, String pluginService) {
        URLClassLoader loader = null;
        try {
            loader = getUrlClassLoader(jar);
            // 加载类
            Class<?> clazz = loader.loadClass(pluginService);
            // 实例化类
            return (PluginService)clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new PluginLoadException(ExceptionCodeEnum.CLASS_LOAD_EXCEPTION);
        }
    }






    public static void main(String[] args) {
//        readPlugin();
//        PluginLoadUtils.instance.loadPlugin("E:\\personalspace\\demo\\target\\");
    }


}
