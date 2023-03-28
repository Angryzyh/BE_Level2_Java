package io.IO_Stream.字节流.InputStream;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;


public class FileInputStream_ {
	String filePath = "E:\\aaa\\aaa.txt";

	@SneakyThrows
	@Test
	@DisplayName("文件输入流读取文件的单个字节")
	void 文件输入流读取文件的单个字节() {   // 读取中文会乱码
		int temp = 0;
		@Cleanup FileInputStream fileInputStream = new FileInputStream(filePath);
		while ((temp = fileInputStream.read()) != -1) {
			System.out.print((char)temp);  // ä½ å¥½,helloã
		}
	}

	@SneakyThrows
	@Test
	@DisplayName("改进文件输入流,自定义缓存数组")
	void 文件输入流读取文件的多个字节() {  // 因为一次缓存读取8个字节,中文一个3个字节,导致可能有中文会乱码
		int temp = 0;
		byte[] bytes = new byte[8];  //建议 1024 大小
		@Cleanup FileInputStream fileInputStream = new FileInputStream(filePath);
		while ((temp = fileInputStream.read(bytes)) != -1) {
			System.out.print(new String(bytes, 0, temp));  // 你好��好,hello。
		}
	}
}
