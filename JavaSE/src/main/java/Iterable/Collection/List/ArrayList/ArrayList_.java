package Iterable.Collection.List.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 可变数组
 * JDK 1.2
 * 不安全,效率高
 * 有参构造 1.5倍扩容
 * 无参构造 初始化容量为10, 后面1.5倍扩容
 */
@SuppressWarnings("all")
public class ArrayList_ {

	@Test
	@DisplayName("ArrayList无参构造扩容机制")
	void ArrayList无参构造扩容机制() {
		// 第一次扩容,初始化容量为10
		ArrayList list = new ArrayList();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		// 第二次扩容(1.5倍),容量为15
		for (int i = 11; i <= 15; i++) {
			list.add(i);
		}
		// 第三次扩容,容量为22.5(取整22)
		list.add(16);
		list.add(17);
		list.add(null);
	}

	/*
	 * ArrayList扩容原理: 无参构造对象初始化不分配容量,在add()方法调用时候会去确认容量是否够用,如果不够就去扩容
	 * 源码调用链路:
	 *       add(E e)
	 *           ↓
	 * ensureCapacityInternal(size + 1)
	 *                         ↓
	 * ensureExplicitCapacity(calculateCapacity(elementData, minCapacity))
	 *        ↓
	 *       grow()
	 * */

	/*
	① 添加(E e)
	public boolean add(E e) {
		// 无参构造,第一次调用add()方法后
		//              ↓ 确保内部容量
		// 首先调用 ensureCapacityInternal(size + 1)
		// size是  private int size  成员变量
		// size + 1 表示当前 需求容量 , 该方法是计算当前集合容量是否够用
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        // ⑥ 把要添加的 数据 赋值给 list[index]后, 成员变量size再自增+1
        elementData[size++] = e;
        return true;
    }

	② 确保内部容量(int minCapacity最小容量)
    private void ensureCapacityInternal(int minCapacity) {
        // 确保显式容量(计算容量(elementData, minCapacity))
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    ③ 计算容量(elementData集合对象, minCapacity最小容量)
     private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // 首先判断传入的集合对象是否等于 ArrayList类内的静态变量 DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
        //                                       默认容量空元素数据
        // private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}  就是空集合
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
             //                                                     默认容量
             // ArrayList类内的静态变量 private static final int DEFAULT_CAPACITY = 10;
             // 如果为空后就调用 Math.max() 判断 默认容量10 和 需求容量 那个大就用那个
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 如果不是空集合对象,就返回minCapacity需求容量
        return minCapacity;
    }

    ④ 确保显式容量(int minCapacity最小容量)
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;  // 用于记录集合修改次数,迭代器有使用
        // overflow-conscious code  如果minCapacity需求容量 > 当前集合的长度(容量)就调用grow(minCapacity) 扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

	⑤  成长(int minCapacity)
	 private void grow(int minCapacity) {
        // overflow-conscious code
        // 把当前集合长度 ->  oldCapacity变量
        int oldCapacity = elementData.length;
        // 当前集合容量扩容1.5倍后的容量  -> newCapacity变量
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新容量 < 当前集合 需求容量 的数值
        if (newCapacity - minCapacity < 0)  // 该判断只在集合, 初始化容量进入
            // 这种情况出现在初始化集合容量的时候
            // 此时集合容量oldCapacity=0,扩容后 newCapacity还是0,那么minCapacity->newCapacity,
            // 注意在第一次初始化时候 minCapacity 经历上述函数已经是10了
            newCapacity = minCapacity;
        // 该判断只在扩容后的容量>Integer.MAX_VALUE - 8 后进入
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            // 处理 容量溢出为 负数
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        // 把原数组数据 copy到 扩容后的数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
	* */

	@Test
	@DisplayName("ArrayList有参构造扩容机制")
	void ArrayList有参构造扩容机制() {
		ArrayList list = new ArrayList(8);
		// 初始化容量为8
		for (int i = 1; i <= 8; i++) {
			list.add(i);
		}
		// 第一次扩容(1.5倍),容量为12
		for (int i = 8; i <= 12; i++) {
			list.add(i);
		}
		// 第二次扩容,容量为18
		list.add(13);
	}
}
