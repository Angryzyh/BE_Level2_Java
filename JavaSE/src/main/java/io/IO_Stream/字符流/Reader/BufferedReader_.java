package io.IO_Stream.字符流.Reader;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {
	String filePath = "E:\\aaa\\aaa.txt";

	@SneakyThrows
	@Test
	@DisplayName("线程安全读取字符文件一行")
	void 线程安全读取字符文件一行() {
		String line = null;
		@Cleanup BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
