package io.IO_Stream.字符流.Writer.OutputStreamWriter;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;

public class FileWriter_ {

	String filePath = "E:\\aaa\\aaa.txt";

	@SneakyThrows
	@Test
	@DisplayName("字符输出流")
	void 字符输出流() {
		@Cleanup FileWriter fileWriter = new FileWriter(filePath,true); // 追加模式
		fileWriter.write("love\n"); // 写入 String字符串
		fileWriter.write('a');   // 写入 char字符
		char[] chars1 = new char[]{'a',256, 'b'};
		//  char[] chars2 = {'a', 12, 'b'};
		fileWriter.write(chars1);  // 写入 char数组
		fileWriter.write("你好呀你好,hello".toCharArray(), 0, 3);  // 写入的字符串转换为数组,在选取内容  写入
		fileWriter.write("你好呀你好,hello", 0, 3);  // 同上
	}
}
