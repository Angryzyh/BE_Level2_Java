package thread.create;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 通过继承创建线程
 * 本质上 Thread类 实现了Runnable接口中的run方法
 */
public class CreateThreadByExtendsThread extends Thread {

    // 继承后重写父类run方法
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":线程在执行!!!");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":线程在执行!!");
        CreateThreadByExtendsThread myThread1 = new CreateThreadByExtendsThread();
        myThread1.start();
        myThread1.startMyThread();
    }

    @Test
    @DisplayName("startMyThread")
    void startMyThread() {
        System.out.println(Thread.currentThread().getName() + ":线程在执行!");
        CreateThreadByExtendsThread myThread2 = new CreateThreadByExtendsThread();
        myThread2.start();
    }
}

