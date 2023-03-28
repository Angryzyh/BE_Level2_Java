package io.IO_Stream.字符流;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

// 文件拷贝
public class DemoBufferedFileCopy {
	// 文本文件
	String sourceTextFilePath = "E:\\aaa\\aaa.txt";
	String targetTextFilePath = "E:\\aaa\\hhp\\hhp.txt";

	// 二进制文件 照片文件
	String sourcePictureFilePath = "E:\\aaa\\logo.jpg";
	String targetPictureFilePath = "E:\\aaa\\hhp\\hhp.jpg";

	@SneakyThrows
	@Test
	@DisplayName("缓冲字符流拷贝文件到指定路径")
	void 缓冲字符流拷贝文件到指定路径() {
		String tempLine = null;
		@Cleanup BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceTextFilePath));
		@Cleanup BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetTextFilePath));
		while ((tempLine = bufferedReader.readLine()) != null) {
			bufferedWriter.write(tempLine);
			bufferedWriter.newLine();
		}
	}

	@SneakyThrows
	@Test
	@DisplayName("缓存字节流拷贝照片到指定路径")
	void 缓存字节流拷贝照片到指定路径() {
		byte[] bytes = new byte[1024];
		int temp;
		@Cleanup BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePictureFilePath));
		@Cleanup BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetPictureFilePath));
		while ((temp = bufferedInputStream.read(bytes)) != -1) {
			bufferedOutputStream.write(bytes, 0, temp);
		}
	}
}
