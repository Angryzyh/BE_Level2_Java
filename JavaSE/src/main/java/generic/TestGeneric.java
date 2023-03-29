package generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 协变就是用一个窄类型替代宽类型
 * 逆变则用宽类型覆盖窄类型。
 *
 * 协变(泛型上限)
 * 作为生产者, List<? extends T>
 * ∵List内的类型都是T或者T的子类,
 * ∴add()添加的时候无法确定子类类型(如都按照上限类型添加,但往往里面有的数据类型是T的子类,就会出现向下转型异常错误),因而在添加的时候就会编译报错
 *   get()获取可以获取 ,获取的类型是T及其父类不需要强转,因为子类转父类 类型自动转换
 *
 * 逆变(泛型下限)
 * 作为消费者,  List<? super T>
 * ∵List内部的类型 都是T或者T的父类,
 * ∴add()可以添加,这是因为添加都可以按照下限类型添加, 数据都可向上自动转型
 *  但是get()获取的时候,如果都按照 下限T获取, 会出现类型由T 向T的父类转换 会出现类型转换异常
 *
 *  */
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
        Object object = numbers.get(0);
        Integer integer = (Integer) numbers.get(0);
        System.out.println("number = " + number);
        System.out.println("object = " + object);
        //集合add()编译报错  规定了类型上限Number 但是add添加的时候,并不知道具体是哪个类型,会直接编译报错
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
        // 因为设置了泛型下限, 所以可以添加, 这是因为 子类转型父类,向上转型可以自动转换
        numbers.add(100);
        System.out.println("numbers = " + numbers);
        //逆变和协变一样，放宽了对数据类型的约束，但是代价是 不能按照泛型类型读取元素
        Object object = numbers.get(0);
        Number number = (Number) numbers.get(0);
        Integer integer = (Integer) numbers.get(0);
        System.out.println("object = " + object);
    }

    @Test
    @DisplayName("数组协变")
    void arrayCovariant() {
        Number[] numbers = new Integer[10];
        //标准的 编译看左边,运行看右边
        numbers[0] = 1.0;
        System.out.println(" numbers[0] = " +  numbers[0]);
    }
}
