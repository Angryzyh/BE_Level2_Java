package reflect.reflect_demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reflect.pojo.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectTime {
    long beforeTime;
    @BeforeEach
    public void beforeEach(){
        beforeTime = System.currentTimeMillis();
    }

    @AfterEach
    public void afterEach() {
        long afterTime = System.currentTimeMillis();
        long l = afterTime - beforeTime;
        System.out.println("耗时= " + l + "毫秒");
    }

    /**
     * 测试 new 对象 调用方法  3ms 3ms 2ms 2ms 2ms   1亿.avg=2.4ms
     */
    @Test
    @DisplayName("testNewObjectTime")
    void testNewObjectTime() {
        System.out.println("TestReflectTime.testNewObjectTime");
        Cat cat = new Cat();
        for (int i = 100000000; i > 0; i--) {
            cat.play();
        }
    }

    /**
     * 测试反射调用方法             97ms 97ms 96ms 101ms 93ms   1亿.avg=96.8ms
     * .setAccessible(true)优化后 65ms 63ms 64ms 64ms 72ms     1亿.avg=52.8ms  ↑83.33%
 ↑    */
    @Test
    @DisplayName("testReflectObjectTime")
    void testReflectObjectTime() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("TestReflectTime.testReflectObjectTime");
        Class<?> clazz = Class.forName("reflect.pojo.Cat");
        Cat cat = (Cat) clazz.newInstance();
        Method playMethod = cat.getClass().getDeclaredMethod("play");
        //true表示反射对象在使用时应禁止 Java 语言访问检查
        playMethod.setAccessible(true);
        for (int i = 100000000; i > 0; i--) {
            playMethod.invoke(cat);
        }
    }


}
