package io.IO_Stream.字符流.Writer;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriter_ {

	String filePath = "E:\\aaa\\aaa.txt";

	@Test
	@DisplayName("字符打印流到System.out标准输出,控制台")
	void 字符打印流() {
		@Cleanup PrintWriter printWriter = new PrintWriter(System.out);
		printWriter.println("你好呀");
	}

	@SneakyThrows
	@Test
	@DisplayName("字符打印流到文件")
	void 字符打印流到文件() {
		@Cleanup PrintWriter printWriter = new PrintWriter(new FileWriter(filePath,true));
		printWriter.println("heeeeeeeeeeee,你好啊");
	}
}
