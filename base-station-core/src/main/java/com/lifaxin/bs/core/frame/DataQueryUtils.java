package com.lifaxin.bs.core.frame;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据查询工具
 *
 * @author FaXin.Li
 * @date 2023/7/19 15:23
 */
public class DataQueryUtils {


    /**
     * 获取列表类数据
     *
     * @param database
     * @return
     * @throws IOException
     */
    public static List<String> getListData(String database) {
        List<String> list = new ArrayList<>();
        // 构建文件地址
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(getAndCreateFile(database), "r")) {
            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);

            buffer.flip();
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
            while (charBuffer.hasRemaining()) {
                StringBuilder sb = new StringBuilder();
                while (charBuffer.hasRemaining()) {
                    char c = charBuffer.get();
                    if (c == '\n') {
                        break;
                    }
                    sb.append(c);
                }
                list.add(sb.toString());
            }
            // 清空关闭资源
            charBuffer.clear();
            buffer.clear();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加列表类数据
     *
     * @param database
     */
    public static void addData(String database, String line) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(getAndCreateFile(database), "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            // 开启追加模式
            channel.position(channel.size());
            channel.write(ByteBuffer.wrap((line + "\n").getBytes()));
            // 清空关闭资源
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearData(String database, String line) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(getAndCreateFile(database), "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            // 开启追加模式
            channel.position(channel.size());
            channel.write(ByteBuffer.wrap((line + "\n").getBytes()));
            // 清空关闭资源
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建或编辑数据文件
     *
     * @param database
     * @return
     */
    private static String getAndCreateFile(String database) throws IOException {
        // 构建文件地址
        StringBuilder stringBuilder = new StringBuilder(System.getProperty("user.home"));
        stringBuilder.append(File.separator);
        stringBuilder.append(Constants.LOCAL_STORE_PLACE);
        Files.createDirectories(Path.of(stringBuilder.toString()));

        stringBuilder.append(File.separator);
        stringBuilder.append(database);
        stringBuilder.append(Constants.SUFFIX);
        // 判断文件是否存在，若不存在则创建
        File bsFile = new File(stringBuilder.toString());
        if (!bsFile.exists()){
            Files.createFile(Path.of(stringBuilder.toString()));
        }
        // 获取文件
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws IOException {
        List<String> dataSet = getListData("plugin");
        for (String item : dataSet) {
            System.out.println(item);
        }

        addData("plugin", "CCC-0002={a:b}");
    }
}
