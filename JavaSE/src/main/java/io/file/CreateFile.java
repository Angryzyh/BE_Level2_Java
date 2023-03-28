package io.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 * 三种方式
 * 1. new File(String pathname)/根据路径构建一个File对象
 * 2. new File(File parent,String child)/根据父目录文件+子路径构建
 * 3. new File(String parent,String child)/根据父目录+子路径构建
 */
public class CreateFile {
    @Test
    @DisplayName("create1")
    void create1() throws IOException {
        File file = new File("e:\\abc.docx");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("无法创建");
            e.printStackTrace();
        }
        // 修改文件最后修改日期
        boolean b = file.setLastModified(System.currentTimeMillis() + 999999999);
        System.out.println("b = " + b);
        // 文件重命名
        boolean b1 = file.renameTo(new File("e:\\aaa.png"));
        System.out.println("b1 = " + b1);
    }

    @Test
    @DisplayName("create2")
    void create2() throws IOException {
        File parentFile = new File("e:\\");
        File file = new File(parentFile, "谢谢啊.txt");
        boolean b = file.createNewFile();
        System.out.println("b = " + b);
    }

    @Test
    @DisplayName("create3")
    void create3() throws IOException {
        String parentPath = "e:\\";
        String childPath = "aaa\\aaa.txt";
        File file = new File(parentPath, childPath);
        //boolean b = file.mkdirs();
        boolean b = file.createNewFile();
        System.out.println("b = " + b);
    }
}
