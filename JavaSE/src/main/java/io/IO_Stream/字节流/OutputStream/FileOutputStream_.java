package io.IO_Stream.字节流.OutputStream;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStream_ {
	String filePath = "E:\\aaa\\aaa.txt";

	@SneakyThrows
	@Test
	@DisplayName("字节输出流")
	void 字节输出流() {
		// @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(filePath); // 以覆盖的形式写入文件内
		@Cleanup FileOutputStream fileOutputStream = new FileOutputStream(filePath, true); // 以追加的形式写入文件内
		String str = "hhp is 憨憨狗";
		// 把字符串的内容写入到指定文件内
		fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8)); // hhp is 憨憨狗
		// 把字符串按照下标选择的内容写入到指定文件内
		fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8), 0, str.length() - 3); //hhp is 憨憨狗hhp is
	}
}
