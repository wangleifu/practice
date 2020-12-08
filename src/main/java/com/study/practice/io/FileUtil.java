package com.study.practice.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/13 14:26
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {
        Logger log = Logger.getGlobal();
        log.setLevel(Level.INFO);
        log.warning("log level: " + log.getLevel());

        String inFileName = "D:\\workspace\\data\\quality\\reader.py";
        String outFileName = "D:\\workspace\\data\\quality\\reader-copy.py";

//        List<String> readList = readFile(inFileName);
//        writeFile(readList, outFileName);

        byte[] bytes = readBytes(inFileName);
        writeBytes(bytes, outFileName);



    }

    public static List<String> readFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException(fileName + " is not exist, please check your param!");
        }
        if (!file.isFile()) {
            throw new RuntimeException(fileName + " is not a file, please check your param!");
        }

        String lineStr = null;
        List<String> lineList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            while ((lineStr = br.readLine()) != null) {
                lineList.add(lineStr.trim());
            }
            return lineList;
        }
    }

    public static void writeFile(List<String> lineList, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new RuntimeException("Failed to create file: " + fileName);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (String line : lineList) {
                bw.write(line + "\r\n");
            }
            bw.flush();
        }
    }

    public static byte[] readBytes(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException(fileName + " is not exist, please check your param!");
        }
        if (!file.isFile()) {
            throw new RuntimeException(fileName + " is not a file, please check your param!");
        }


        try (ByteChannel channel = new FileInputStream(file).getChannel();
             ByteArrayOutputStream bis = new ByteArrayOutputStream()) {
            ByteBuffer byteBuffer =  ByteBuffer.allocate(1024);
            int len = 0;
            while ((len = channel.read(byteBuffer)) != -1) {
                bis.write(byteBuffer.array(),0,len);
                byteBuffer.clear();
            }
            return bis.toByteArray();
        }
    }

    public static void writeBytes(byte[] bytes, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new RuntimeException("Failed to create file: " + fileName);
            }
        }


        try (ByteChannel channel = new FileOutputStream(file).getChannel()) {
            ByteBuffer byteBuffer =  ByteBuffer.wrap(bytes);
            channel.write(byteBuffer);
        }
    }
}
