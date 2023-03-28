package io.file;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

	String filePath = "src\\main\\java\\io\\file\\config.properties";

	@SneakyThrows
	@Test
	@DisplayName("jdk的api读取properties文件")
	void 读取properties文件() {
		String tempLine;
		@Cleanup BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		while ((tempLine = bufferedReader.readLine()) != null) {
			String[] split = tempLine.split("=");
			System.out.println("key:" + split[0] + " value:" + split[1]);
		}
	}

	@SneakyThrows
	@Test
	@DisplayName("创建properties对象读取文件")
	void 创建properties对象读取文件() {
		Properties properties = new Properties();
		properties.load(new FileReader(filePath));
		// 查询一个key的值
		String id = properties.getProperty("id");
		System.out.println("id = " + id);
		// 打印key-value列表
		properties.list(System.out);
	}

	@SneakyThrows
	@Test
	@DisplayName("创建properties对象写入文件")
	void 创建properties对象写入文件() {
		Properties properties = new Properties();
		properties.setProperty("address", "南京");  //如果key存在就是修改
		properties.store(new FileWriter(filePath, true),"地址");  //存的是utf8中文
		// properties.store(new FileOutputStream(filePath, true),"地址");  //中文存的是unicode
	}
}
