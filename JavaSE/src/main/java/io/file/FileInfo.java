package io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取文件信息
 */
public class FileInfo {
    public static void main(String[] args) throws IOException {
        File file = new File("e:\\aaa\\aaa.txt");

        //获取文件路径 +文件名
        // file.getAbsoluteFile();  File类型          e:\aaa\aaa.txt
        // file.getAbsolutePath();  String类型        e:\aaa\aaa.txt
        File absoluteFile = file.getAbsoluteFile();
        System.out.println("absoluteFile = " + absoluteFile);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);


        // 获取文件规范的路径 +文件名
        // file.getCanonicalFile();   File类型       E:\aaa\aaa.txt
        // file.getCanonicalPath();   String类型     E:\aaa\aaa.txt
        File canonicalFile = file.getCanonicalFile();
        System.out.println("canonicalFile = " + canonicalFile);
        String canonicalPath = file.getCanonicalPath();
        System.out.println("canonicalPath = " + canonicalPath);

        //获取父文件路径
        // file.getParentFile();     File类型     e:\aaa
        // file.getParent();         String类型   e:\aaa
        File parentFile = file.getParentFile();
        System.out.println("parentFile = " + parentFile);
        String parent = file.getParent();
        System.out.println("parent = " + parent);

        // 获取文件路径
        // file.getPath()  String类型  e:\aaa\aaa.txt
        String path = file.getPath();
        System.out.println("path = " + path);

        // =================================================================

        //判断文件是否存在  file.exists()
        boolean exists = file.exists();
        System.out.println("exists = " + exists);

        // 判断是否是一个文件  file.isFile()
        boolean file1 = file.isFile();
        System.out.println("file1 = " + file1);

        // 判断是否是一个目录 file.isDirectory()
        boolean directory = file.isDirectory();
        System.out.println("directory = " + directory);

        // 判断文件是否 是绝对路径  file.isAbsolute()
        boolean absolute = file.isAbsolute();
        System.out.println("absolute = " + absolute);

        // 获取文件名称
        // file.getName()  String类型   aaa.txt
        String name = file.getName();
        System.out.println("name = " + name);

        // 文件大小(字节 B)
        // file.length()
        long length = file.length();
        System.out.println("length(字节 B) = " + length);

        // 查看文件最后修改日期
        long l = file.lastModified();
        System.out.println("l(查看文件最后修改日期)= " + l);
        Date date = new Date(l);
        System.out.println("date = " + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);


        // E盘可用空间  单位字节 B
        long freeSpace = file.getFreeSpace();
        System.out.println("freeSpace = " + freeSpace/1024/1024/1024 + "GB");
        long usableSpace = file.getUsableSpace();
        System.out.println("usableSpace = " + usableSpace/1024/1024/1024 + "GB");

        // E盘总空间   单位字节 B
        long totalSpace = file.getTotalSpace();
        System.out.println("totalSpace = " + totalSpace/1024/1024/1024 + "GB");
    }
}
