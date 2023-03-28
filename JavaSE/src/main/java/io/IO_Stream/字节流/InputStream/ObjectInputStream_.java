package io.IO_Stream.字节流.InputStream;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
	String filePath = "e:\\aaa\\abc.txt";

	@SneakyThrows
	@Test
	@DisplayName("读取序列化文件")
	void 读取序列化文件() {
		@Cleanup ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
		System.out.println(objectInputStream.readBoolean());
		System.out.println(objectInputStream.readInt());
		System.out.println(objectInputStream.readUTF());
		Object d = objectInputStream.readObject();
		System.out.println("d = " + d.getClass());
		System.out.println("d = " + d);
	}
}
