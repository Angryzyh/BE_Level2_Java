package annotation.demo;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Data
@Builder
@Accessors(chain = true)
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@DefaultValue(intValue = 100001)
	private Integer uid;
	@DefaultValue(strValue = "张三")
	private String username;
	@DefaultValue(strValue = "123456")
	private String password;

	@SneakyThrows
	public static User setDefaultValue() {
		// 获取 类对象实例
		User user = User.class.newInstance();
		// 获取对象的 Class类型
		Class<? extends User> uClass = user.getClass();
		// 获取 对象属性(成员变量)
		Field[] declaredFields = uClass.getDeclaredFields();
		// 迭代 全部属性
		for (Field declaredField : declaredFields) {
			// 暴力破解,设置私有属性可访问
			declaredField.setAccessible(true);
			// 获取 自定义注解  因为范围选择注解位置为任意@Target(ElementType.TYPE_USE)
			// ∴用 新的api访问 getAnnotatedType().getAnnotation(T.class)
			DefaultValue annotation = declaredField.getAnnotatedType().getAnnotation(DefaultValue.class);
			// 判断 属性的 类型
			if (("Integer").equals(declaredField.getType().getSimpleName())) {
				// 获取注解内的值
				Integer num = annotation.intValue();
				// 迭代 对象的全部方法,目的是获取 setXxx  set属性的方法
				Method[] declaredMethods = uClass.getDeclaredMethods();
				for (Method declaredMethod : declaredMethods) {
					// 采用set方法的特点  为 set + 属性名首字母大写
					// ∴ "set" +
					//  declaredField.getName().substring(0, 1).toUpperCase()  此部分为属性首字母大写
					//  declaredField.getName().substring(1)  此部分获取剩下属性名的除首字母,其余字母
					// if 内 equals 比较到了 对应的方法名就执行该方法
					if (("set" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1)).equals(declaredMethod.getName())) {
						/*方法四要素
						1. 什么对象
						2. 什么方法
						3. 什么参数
						4. 什么返回值*/
						// 反射api  方法.invoke(对象,方法参数)
						// 因为该方法是 set方法没有返回值 所以就不需要接收返回值
						declaredMethod.invoke(user, num);
					}
				}
			} else if (("String").equals(declaredField.getType().getSimpleName())) {
				String str = annotation.strValue();
				Method[] declaredMethods = uClass.getDeclaredMethods();
				for (Method declaredMethod : declaredMethods) {
					if (("set" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1)).equals(declaredMethod.getName()))
						declaredMethod.invoke(user, str);
				}
			}
		}
		return user;
	}
}
