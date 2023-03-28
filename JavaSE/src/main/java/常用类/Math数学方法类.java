package 常用类;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class Math数学方法类 {
	@Test
	@DisplayName("获取随机数")
	void 获取随机数() {
		// 获取一个 [0.0,1.0) 的双精度浮点数
		double random = Math.random();
		System.out.println("random = " + random);
	}

	@Test
	@DisplayName("获取[1,100]随机数")
	void 获取1到100随机数() {
		double random = Math.random();
		Integer x = (int)(random * 100 + 1);
		System.out.println("x = " + x);
	}
	
	@Test
	@DisplayName("BigDecimal保留2位小数")
	void BigDecimal保留2位小数() {
		double random = Math.random();
		BigDecimal bigDecimal = new BigDecimal(random);
		BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("bigDecimal1 = " + bigDecimal1);
	}

	@Test
	@DisplayName("String.Format()方法保留2位小数")
	void  String的Format方法() {
		double random = Math.random();
		String string = String.format("%.2f", random).toString();
		System.out.println("string = " + string);
	}
}
