package reflect.reflect_demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reflect.pojo.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射入门案例
 * 对比new创建对象 和 通过反射获取对象
 */
public class FastReflect {
    /**
     * 一般通过new创建对象
     */
    @Test
    @DisplayName("getObjectByNew")
    void getObjectByNew() {
        Cat cat = new Cat();
        cat.hi();
    }

    @Test
    @DisplayName("getObjectByReflect")
    void getObjectByReflect() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        // 加载properties文件
        properties.load(new FileInputStream("src\\main\\java\\reflect\\pojo.properties"));
        // 获取properties文件中的key
        String classpath = properties.getProperty("classpath");
        String methodName = properties.getProperty("method");
        String catName = properties.getProperty("cat.name");
        // 通过Class类 获取指定的类对象
        Class<?> clazz = Class.forName(classpath);
        // 类对象调用newInstance通过反射创建对象
        Object o = clazz.newInstance();
        System.out.println("获取o的运行时类型 = " + o.getClass());
        System.out.println("通过Class类对象获取[方法对象]:============================================================");
        //通过Class类对象 获取方法对象
        Method method = clazz.getMethod(methodName);
        //对象具体的方法.invoke(对象)  执行对象具体的方法
        Object result = method.invoke(o);
        // 输出 返回值 如果该方法为void 则返回值为null
        System.out.println("result = " + result);
        System.out.println("通过Class类对象获取[构造方法对象]:============================================================");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        //通过构造方法对象 创建cat对象
        Object o1 = constructor.newInstance(catName);
        System.out.println("o1 = " + o1);

        System.out.println("通过Class类对象获取[属性对象]:============================================================");
        Field fieldName = clazz.getDeclaredField("name");
        Object value = fieldName.get(o1);
        System.out.println("fieldName = " + value);
        System.out.println("field = " + fieldName);  //private java.lang.String reflect.pojo.Cat.name
        System.out.println("fieldName = " + fieldName.getName());  //name
        //通过 属性对象.set 修改对象的成员变量
        // 其中成员变量必须是public的 否则无法修改
        fieldName.set(o1, "憨憨");
        System.out.println("o1 = " + o1);
      /*
        //探究  反射获取方法的四种方法
        Method hi1 = clazz.getMethod("hi");
        System.out.println("getMethod===hi1 = " + hi1);
        Method[] methods = clazz.getMethods();
        System.out.println("getMethods= " + Arrays.toString(methods));
        Method hi2 = clazz.getDeclaredMethod("hi");
        System.out.println("getDeclaredMethod===hi2 = " + hi2);
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("declaredMethods = " + Arrays.toString(declaredMethods));*/

        /*
        @Data注解pojo getMethods 获取到的方法
        getMethods=
        [public boolean reflect.pojo.Cat.equals(java.lang.Object),
        public java.lang.String reflect.pojo.Cat.toString(),
        public int reflect.pojo.Cat.hashCode(),
        public java.lang.String reflect.pojo.Cat.getName(),
        public void reflect.pojo.Cat.setName(java.lang.String),
        public void reflect.pojo.Cat.hi(),
        public final void java.lang.Object.wait() throws java.lang.InterruptedException,
        public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException,
        public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException,
        public final native java.lang.Class java.lang.Object.getClass(),
        public final native void java.lang.Object.notify(),
        public final native void java.lang.Object.notifyAll()]
        ===============================================================================================
        手动添加getter&setter&构造方法  getMethods  获取到的方法
        getMethods=
        [public java.lang.String reflect.pojo.Cat.getName(),
        public void reflect.pojo.Cat.setName(java.lang.String),
        public void reflect.pojo.Cat.hi(),
        public final void java.lang.Object.wait() throws java.lang.InterruptedException,
        public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException,
        public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException,
        public boolean java.lang.Object.equals(java.lang.Object),
        public java.lang.String java.lang.Object.toString(),
        public native int java.lang.Object.hashCode(),
        public final native java.lang.Class java.lang.Object.getClass(),
        public final native void java.lang.Object.notify(),
        public final native void java.lang.Object.notifyAll()]
         */

        /*
        @Data注解pojo  getDeclaredMethods  获取到的方法
        declaredMethods =
        [public boolean reflect.pojo.Cat.equals(java.lang.Object),
        public java.lang.String reflect.pojo.Cat.toString(),
        public int reflect.pojo.Cat.hashCode(),
        public java.lang.String reflect.pojo.Cat.getName(),
        public void reflect.pojo.Cat.setName(java.lang.String),
        public void reflect.pojo.Cat.hi(),
        protected boolean reflect.pojo.Cat.canEqual(java.lang.Object)]
        =====================================================================
        手动添加getter&setter&构造方法  getDeclaredMethods  获取到的方法
        declaredMethods =
        [public java.lang.String reflect.pojo.Cat.getName(),
        public void reflect.pojo.Cat.setName(java.lang.String),
        public void reflect.pojo.Cat.hi()]
         */
    }
}
