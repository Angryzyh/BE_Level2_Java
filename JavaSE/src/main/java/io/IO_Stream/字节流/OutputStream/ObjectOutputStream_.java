package io.IO_Stream.字节流.OutputStream;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStream_ {
	String filePath = "e:\\aaa\\abc.txt";

	@SneakyThrows
	@Test
	@DisplayName("序列化存储到文件内")
	void 序列化存储到文件内() {
		@Cleanup ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath, true));
		objectOutputStream.writeBoolean(true);
		objectOutputStream.writeInt(1000);
		objectOutputStream.writeUTF("张憨憨");
		objectOutputStream.writeObject(new Dog("hhp",20));
	}
}

@Data
@AllArgsConstructor
class Dog implements Serializable {
	private String name;
	private Integer age;
}


