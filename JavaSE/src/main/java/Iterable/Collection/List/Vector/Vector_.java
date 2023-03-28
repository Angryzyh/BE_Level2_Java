package Iterable.Collection.List.Vector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Vector;

/**
 * 可变数组
 * JDK 1.0
 * 安全,效率低
 * 有参构造, 每次2倍扩容
 * 无参构造, 初始化容量为10, 后面2倍扩容
 */
@SuppressWarnings("all")
public class Vector_ {

	@Test
	@DisplayName("Vector无参构造扩容机制")
	void Vector无参构造扩容机制() {
		// 第一次扩容,初始化容量为10
		Vector vector = new Vector();
		for (int i = 1; i <= 10; i++) {
			vector.add(i);
		}
		// 第二次扩容(2倍),容量为20
		for (int i = 11; i <= 20; i++) {
			vector.add(i);
		}
		// 第三次扩容,容量为40
		vector.add(21);
	}

	/*
	 * Vector扩容原理: 无参构造对象初始化阶段就已经分配容量 10
	 * 源码调用链路:
	 *      new Vector()  无参构造方法
	 *           ↓
	 *      new Vector(int initialCapacity) 有参构造方法(初始化容量)
	 *           ↓
	 *      new Vector(int initialCapacity, int capacityIncrement)  有参构造方法(初始化容量, 容量增量)
	 *           ↓
	 *      add() 添加元素
	 *           ↓
	 *      ensureCapacityHelper(int minCapacity)  确保容量助手(需求容量)
	 *           ↓
	 *      grow(int minCapacity)  扩容(需求容量)
	 * */

	/*
	① 无参构造方法()
	public Vector() {
		// 调用有参构造方法, 初始化容量为10
        this(10);
    }

    ② 有参构造方法(int initialCapacity初始容量)
    public Vector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    ③ 有参构造方法(int initialCapacity初始容量, int capacityIncrement容量增量)
    public Vector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        // 根据初始化容量10,初始化数组
        this.elementData = new Object[initialCapacity];
        // 把容量增量赋值给,成员变量
        this.capacityIncrement = capacityIncrement;
    }

    ④ add(E e)
    public synchronized boolean add(E e) {
        // 记录集合修改次数
        modCount++;
        // 确保容量助手(elementCount 成员变量 记录当前集合 已使用长度, +1 再加一是为了确保有容量存下当前放入的数据)
        ensureCapacityHelper(elementCount + 1);
        // 存入数据,并把集合的有效长度+1
        elementData[elementCount++] = e;
        return true;
    }

    ⑤ 确保容量助手(int minCapacity最小容量)
    private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        // 判断当前 需求容量 ,是否超出了 集合长度
        if (minCapacity - elementData.length > 0)
            // 如果超出就扩容
            grow(minCapacity);
    }

    ⑥ 成长(int minCapacity最小容量)
    private void grow(int minCapacity) {
        // overflow-conscious code
        // 把当前集合长度 -> oldCapacity
        int oldCapacity = elementData.length;
        // 三目运算,首先判断capacityIncrement成员变量容量增量是否>0,该变量默认为0
        // 所以默认就是 oldCapacity + oldCapacity 即实现了2倍扩容
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
        // 判断 扩容后的容量 如果依然 小于 需求容量 那就选择需求容量作为扩容后的容量
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // 判断容量溢出的问题
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 把原数组数据 copy到 扩容后的数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
	* */


	@Test
	@DisplayName("Vector有参构造扩容机制")
	void Vector有参构造扩容机制() {
		Vector vector = new Vector(8);
		// 初始化容量为8
		for (int i = 1; i <= 8; i++) {
			vector.add(i);
		}
		// 第一次扩容(2倍),容量为16
		for (int i = 8; i <= 16; i++) {
			vector.add(i);
		}
		// 第二次扩容,容量为32
		vector.add(17);
	}
}
