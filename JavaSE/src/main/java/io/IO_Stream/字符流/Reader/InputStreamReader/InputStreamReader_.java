package io.IO_Stream.字符流.Reader.InputStreamReader;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

// InputStream字节流 转换为 Reader字符流
public class InputStreamReader_ {

	String filePath = "E:\\aaa\\bbb.txt";

	@SneakyThrows
	@Test
	@DisplayName("字节流按照编码格式转换为字符流读取")
	void 字节流按照编码格式转换为字符流读取() {
		String tempLine;
		//                                                                                StandardCharsets.UTF_8
		@Cleanup BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), Charset.forName("GBK")));
		while ((tempLine = bufferedReader.readLine()) != null) {
			System.out.println(tempLine);
		}
	}
}
