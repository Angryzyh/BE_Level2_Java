package annotation.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_ {
	@Test
	@DisplayName("测试自定义赋值默认值注解")
	void 测试自定义赋值默认值注解() {
		User user = User.setDefaultValue();
		System.out.println("user = " + user);
	}
}
