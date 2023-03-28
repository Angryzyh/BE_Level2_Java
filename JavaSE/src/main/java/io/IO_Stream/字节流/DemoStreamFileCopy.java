package io.IO_Stream.字节流;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// 文件拷贝
public class DemoStreamFileCopy {
	String sourceFilePath = "E:\\aaa\\logo.jpg";
	String targetFilePath = "E:\\aaa\\hhp\\hhp.jpg";

	@SneakyThrows
	@Test
	@DisplayName("拷贝照片到指定路径")
	void 拷贝照片到指定路径() {
		int temp = 0;
		byte[] bytes = new byte[1024];
		@Cleanup FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
		@Cleanup FileOutputStream fileOutputStream = new FileOutputStream(targetFilePath);
		while ((temp = fileInputStream.read(bytes)) != -1) {
			fileOutputStream.write(bytes, 0, temp);
		}
	}
}
