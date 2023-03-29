package generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 单泛型
public class SingleGeneric<T> {

	// 打印
	public <T> void Printer(T t) {
		System.out.println("T = " + t);
	}

	// 数据返回
	public <T> T Valuer(T t) {
		return t;
	}
}

// 双泛型
class DoubleGeneric<T, V> {
	// 打印
	public <T, V> void Printer(T t, V v) {
		System.out.println("T = " + t);
		System.out.println("V = " + v);
	}

	// 数据返回
	public <T, V> V Valuer(T t, V v) {
		return v;
	}
}

//  装饰器模式搭配单泛型
class DecoratorGeneric<T> {

	private T t;

	public DecoratorGeneric(T t) {
		this.t = t;
	}

	// 打印
	public void Printer() {
		System.out.println("T = " + t);
	}

	// 数据返回
	public T Valuer() {
		return t;
	}
}

class Test_ {
	@Test
	@DisplayName("测试单泛型")
	void 测试单泛型() {
		SingleGeneric<Integer> singleGeneric = new SingleGeneric<>();
		singleGeneric.Printer(11);
		Integer valuer = singleGeneric.Valuer(100);
		System.out.println("valuer = " + valuer);
	}

	@Test
	@DisplayName("测试双泛型")
	void 测试双泛型() {
		DoubleGeneric<String, Integer> doubleGeneric = new DoubleGeneric<>();
		doubleGeneric.Printer("你好", 121);
		Integer valuer = doubleGeneric.Valuer("hello,大家好", 41);
		System.out.println("valuer = " + valuer);
	}

	@Test
	@DisplayName("测试装饰器模式单泛型")
	void 测试装饰器模式单泛型() {
		DecoratorGeneric<String> decoratorGeneric = new DecoratorGeneric<>("whatFuck");
		decoratorGeneric.Printer();
		Object valuer = decoratorGeneric.Valuer();
		System.out.println("valuer = " + valuer);
	}
}