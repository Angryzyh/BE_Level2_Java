package reflect.class_;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

/**
    获取所有类型的Class
 */
public class AllTypeClassObject {
    @Test
    @DisplayName("getAllTypeClassObject")
    void getAllTypeClassObject() {
        //1. 外部类, 成员内部类, 静态内部类, 局部内部类, 匿名内部类, 抽象类
        Class<String> clazz1 = String.class;
        //2. interface 接口
        Class<Serializable> clazz2 = Serializable.class;
        //3. 一维数组
        Class<int[]> clazz3 = int[].class;
        //4. 三维数组
        Class<Integer[][][]> clazz4 = Integer[][][].class;
        //5. 注解
        Class<Deprecated> clazz5 = Deprecated.class;
        //6. 枚举
        Class<Thread.State> clazz6 = Thread.State.class;
        //7. 基本数据类型, byte char short int long double float boolean
        Class<Byte> clazz7 = byte.class;
        //8. void 返回值类型
        Class<Void> clazz8 = void.class;
        //9. Class本类
        Class<Class> clazz9 = Class.class;

        System.out.println("clazz1 = " + clazz1);
        System.out.println("clazz2 = " + clazz2);
        System.out.println("clazz3 = " + clazz3);
        System.out.println("clazz4 = " + clazz4);
        System.out.println("clazz5 = " + clazz5);
        System.out.println("clazz6 = " + clazz6);
        System.out.println("clazz7 = " + clazz7);
        System.out.println("clazz8 = " + clazz8);
        System.out.println("clazz9 = " + clazz9);
    }
}
