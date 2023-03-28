package reflect.class_;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取Class对象的四种方式
 */
public class GetClass {
    /*
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
    */

    @Test
    @DisplayName("getClass")
    void getClassFourWay() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
         /*
            第一种: 在编译阶段
            用法:   Class.forName("类全限定名称")
            应用场景: 配置文件,读取类全限定名称
         */
        Class<?> clazz1 = Class.forName("reflect.pojo.Cat");
        System.out.println("clazz1 = " + clazz1);

        /*
            第二种: 通过类加载器创建对象
            用法:   对象.getClass().getClassLoader().loadClass("类全限定名称")
            应用场景: 通过创建好的对象,获取Class对象
         */
        //Cat cat = new Cat();
        Object o = clazz1.newInstance();
        Class<?> clazz2 = o.getClass().getClassLoader().loadClass("reflect.pojo.Cat");
        System.out.println("clazz2 = " + clazz2);

        /*
            第三种: 在类加载阶段  类.class 类的class属性来获取对象
            用法:   类.class
            应用场景: 用于参数传递,比如通过反射得到对应的有参构造器对象,构造器内的参数就用  类.class 定义
         */
        Constructor<?> constructor = clazz1.getConstructor(String.class);
        System.out.println("constructor = " + constructor);
        Object o2 = constructor.newInstance("大猫");
        System.out.println("clazz3 = " + String.class);

        /*
            第四种: 在运行阶段  对象.getClass()方法  来获取对象
            用法:   对象.getClass()
            应用场景: 通过创建好的对象获取Class对象
         */
        Class<?> clazz4 = o.getClass();
        System.out.println("clazz4 = " + clazz4);
    }

}
