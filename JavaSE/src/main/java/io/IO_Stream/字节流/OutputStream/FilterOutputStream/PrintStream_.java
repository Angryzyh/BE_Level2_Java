package io.IO_Stream.字节流.OutputStream.FilterOutputStream;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrintStream_ {

	String filePath = "E:\\aaa\\aaa.txt";

	@Test
	@DisplayName("测试标准打印流System.out")
	void test1() {
		System.out.println(System.out.getClass());  //class java.io.PrintStream
	}

	@Test
	@DisplayName("测试标准键盘输入流System.in")
	void test2() {
		System.out.println(System.in.getClass());  // 编译 java.io.InputStream  运行  class java.io.BufferedInputStream
	}

	@SneakyThrows
	@Test
	@DisplayName("字节输出流")
		void 字节输出流() {
			@Cleanup PrintStream out = System.out;
			out.println("你好");
			out.write("你好呀".getBytes(StandardCharsets.UTF_8));
			System.setOut(new PrintStream(filePath));
			System.out.write("hello".getBytes(StandardCharsets.UTF_8));
		}

		public static void main(String[] args) {  //测试标准输出到屏幕控制台
		@Cleanup Scanner scanner = new Scanner(System.in);
		System.out.println("你输入内容:");
		String next = scanner.next();
		System.out.println(next);
	}
}
