package io.IO_Stream.字符流.Writer;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriter_ {
	String filePath = "E:\\aaa\\aaa.txt";

	@SneakyThrows
	@Test
	@DisplayName("线程安全写入字符文件")
	void 线程安全写入字符文件() {
		@Cleanup BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
		bufferedWriter.write("\n我是渣渣辉");
		bufferedWriter.newLine();   //换行符
	}
}
