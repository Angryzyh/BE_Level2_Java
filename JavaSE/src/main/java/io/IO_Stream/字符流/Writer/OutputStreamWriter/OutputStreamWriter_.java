package io.IO_Stream.字符流.Writer.OutputStreamWriter;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

// OutputStream字节流 转换为 Writer字符流
public class OutputStreamWriter_ {

	String filePath = "E:\\aaa\\bbb.txt";

	@SneakyThrows
	@Test
	@DisplayName("字节流按照编码格式转换为字符流输出到文件内")
	void 字节流按照编码格式转换为字符流输出到文件内() {
		@Cleanup BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath ,true), Charset.forName("GBK")));
		bufferedWriter.write("字节流转换成指定编码的字符流输出到文本内");
		bufferedWriter.newLine();
	}
}
