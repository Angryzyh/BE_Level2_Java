package io.IO_Stream.字符流.Reader.InputStreamReader;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

public class FileReader_ {

	String filePath = "E:\\aaa\\aaa.txt";

	@SneakyThrows
	@Test
	@DisplayName("字符输入流_每次读取单个字符")
	void 字符输入流_每次读取单个字符() {  // 每次
		int tempChar = 0;
		@Cleanup FileReader fileReader = new FileReader(filePath);
		while ((tempChar = fileReader.read()) != -1) {
			System.out.print((char) tempChar);
		}
	}

	@SneakyThrows
	@Test
	@DisplayName("字符输入流_每次读取数组长度的字符")
	void 字符输入流_每次读取数组长度的字符() {
		int charNum = 0;
		char[] chars = new char[8];
		@Cleanup FileReader fileReader = new FileReader(filePath);
		while ((charNum = fileReader.read(chars)) != -1) {
			System.out.print(new String(chars, 0, charNum));
		}
	}
}
