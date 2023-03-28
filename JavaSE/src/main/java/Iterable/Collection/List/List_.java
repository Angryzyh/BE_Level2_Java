package Iterable.Collection.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class List_ {

	@Test
	@DisplayName("List接口的方法")
	void List接口的方法() {
		List list = new ArrayList();
		Collections.addAll(list, "jack", "tom", "blue", "marry", "green", "tom", "white");
		System.out.println("list = " + list);
		//1. add(index,object): 添加元素到指定索引位置
		list.add(4, "love");
		System.out.println("list = " + list);
		//2. get(index): 获取下标索引的元素
		System.out.println(list.get(2));
		//3. indexOf(object): 查找元素第一次出现的位置
		int i = list.indexOf("tom");
		System.out.println("i = " + i);
		//4. lastIndexOf(object): 查找元素最后一次出现的位置
		int i1 = list.lastIndexOf("tom");
		System.out.println("i1 = " + i1);
		//5. remove(index): 删除指定索引的元素
		list.remove(0);
		System.out.println("list = " + list);
		//6. set(index, object): 替换目标索引位置的元素
		list.set(1, "tomWang");
		System.out.println("list = " + list);
		//7. subList(fromIndex, toIndex): 获取两个索引之间的元素集合[a,b)
		List list1 = list.subList(1, 3);
		System.out.println("list1 = " + list1);
	}

	@Test
	@DisplayName("四种遍历list集合操作")
	void 四种遍历list集合操作() {
		List list = new ArrayList();
		Collections.addAll(list, "jack", "tom", "blue", "marry", "green", "tom", "white");
		//1. for循环   .fori
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		//2. 增强for循环  .for
		for (Object o : list) {
			System.out.println("o = " + o);
		}

		//3.迭代器iterator  itit
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			System.out.println("next = " + next);
		}

		//4.  forEach()遍历   soutc
		list.forEach(System.out::println);
	}
}
