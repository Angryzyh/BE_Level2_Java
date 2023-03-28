package io.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileDirectory {
	String filePath = "E:\\aaa\\aaa.txt";
	String directoryPath = "E:\\aaa\\bbb";
	File file = new File(filePath);
	File directory = new File(directoryPath);

	@Test
	@DisplayName("删除文件")
	void 删除文件() {
		if (file.isFile()) {
			if (file.delete()) {
				System.out.println(filePath + "删除成功");
			} else {
				System.out.println(filePath + "删除失败");
			}
		} else {
			System.out.println("该文件不存在");
		}
	}

	@Test
	@DisplayName("判断目录是否存在不存在就创建")
	void 判断目录是否存在不存在就创建() {
		if (directory.exists()) {
			System.out.println(directoryPath + "目录已经存在");
		} else {
			if (directory.mkdirs()) {
				System.out.println(directoryPath + "目录创建成功");
			} else {
				System.out.println(directoryPath + "目录创建失败");
			}
		}
	}
}
