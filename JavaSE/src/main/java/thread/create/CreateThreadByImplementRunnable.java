package thread.create;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 创建线程,通过实现Runnable接口
 */
public class CreateThreadByImplementRunnable implements Runnable {

    // 实现 Runnable 接口 需要实现 其内部的抽象方法 run()
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":线程在执行!");
    }

    @Test
    @DisplayName("通过实现Runnable接口实现")
    void test1() {
        Thread thread = new Thread(new CreateThreadByImplementRunnable());
        thread.start();
    }

    @Test
    @DisplayName("通过匿名内部类实现")
    void test2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":线程在执行!!");
            }
        });
        thread.start();
    }

    @Test
    @DisplayName("通过lambda表达式实现")
    void test3() {
        Thread thread = new Thread(()->System.out.println(Thread.currentThread().getName() + ":线程在执行!!"));
        thread.start();
    }
}
