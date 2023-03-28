package Iterable.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

//Collections工具类方法
@SuppressWarnings("all")
public class Collection_ {

    @Test
    @DisplayName("Collection接口的方法")
    void Collection接口的方法() {
        //1. add(object):添加一个元素
        Collection list = new ArrayList();
        list.add("hello");
        list.add(110);
        System.out.println("list = " + list);
        //2. remove(object):删除指定元素
        list.remove("hello");
        System.out.println("list = " + list);
        //3. contains(object): 查找某个元素是否存在
        boolean hello = list.contains("hello");
        System.out.println("hello = " + hello);
        //4. size(): 获取元素内的个数
        int size = list.size();
        System.out.println("size = " + size);
        //5. isEmpty(): 判断集合是否为空
        boolean empty = list.isEmpty();
        System.out.println("empty = " + empty);
        //6. clear(): 清空集合
        list.clear();
        System.out.println(list);
        //7. addAll(list): 添加指定集合的所有元素到调用者内
        Collection list2 = new ArrayList();
        list2.add("上刀山");
        list2.add("下火海");
        list.addAll(list2);
        System.out.println("list = " + list);
        //8. containsAll(list): 如果此列表包含指定集合的所有元素，则返回 true
        boolean b = list.containsAll(list2);
        System.out.println("b = " + b);
        //9. removeAll(list): 删除多个元素
        list.removeAll(list2);
        System.out.println("list = " + list);
    }
}
