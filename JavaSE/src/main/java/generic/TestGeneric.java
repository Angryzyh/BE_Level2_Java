package generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的 协变(作为生产者,∵无法添加只能get获取)
 * 与
 * 逆变(作为消费者,∵有下限,∴可以添加,但是获取的时候不知道类型,对外别人不能get,只能add消费)
 */
public class TestGeneric {
    /**
     * 协变 covariant
     */
    @Test
    @DisplayName("协变(泛型上限)")
    void covariant() {
        //List<Number> numbers = new ArrayList<Integer>();  //报错
        List<? extends Number> numbers = new ArrayList<>();
        /*
            协变---设置了泛型上限
            在 Java 中用通配符 ? extends T 表示协变，
            extends 限制了父类型 T，
            其中 ? 表示未知类型，
            只要声明时传入的类型是 Number 或者 Number 的子类型都可以
         */
        //集合get()编译不报错,运行报错
        Number number = numbers.get(0);
        System.out.println("number = " + number);
        //集合add()编译报错
        //numbers.add(1);
    }

    /**
     * 逆变 inversion
     */
    @Test
    @DisplayName("逆变(泛型下限)")
    void inversion() {
        // 逆变 设置了 泛型下限为Number类型
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(100);
        System.out.println("numbers = " + numbers);
        //逆变和协变一样，放宽了对数据类型的约束，但是代价是 不能按照泛型类型读取元素
        Object object = numbers.get(0);
        System.out.println("object = " + object);
    }

    @Test
    @DisplayName("数组协变")
    void arrayCovariant() {
        Number[] numbers = new Integer[10];
        //标准的 编译看右边,运行看左边
        numbers[0] = 1.0;
        System.out.println(" numbers[0] = " +  numbers[0]);
    }
}
