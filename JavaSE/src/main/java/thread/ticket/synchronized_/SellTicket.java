package thread.ticket.synchronized_;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
    模拟 三个窗口售票 , 通过继承和实现接口创建多线程
    通过加synchronized 或者 synchronized()同步代码块  解决超卖问题
 */
public class SellTicket {
    /*
        测试 通过 extends Thread 模拟多线程卖票
     */
    @Test
    @DisplayName("SellTicketByThread")
    void SellTicketByThread() {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();
        //继承Thread 结果发生了超卖现象
        try {
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
       测试 通过 implements Runnable 模拟多线程卖票
    */
    @Test
    @DisplayName("SellTicketByRunnable")
    void SellTicketByRunnable() {
        R r = new R();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(r);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T extends Thread {
    public static int ticketNum = 100;
    public boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            sell();
        }
    }

    public /*synchronized*/ void sell() {
        synchronized (T.class) {
            if (ticketNum <= 0) {
                flag = false;
                System.out.println("票已售空");
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "窗口:卖出了一张票,还剩余:" + (--ticketNum));
        }
    }
}

class R implements Runnable {
    public static int ticketNum = 100;
    public boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            sell();
        }
    }

    public synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("票已售空");
            flag = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "窗口:卖出了一张票,还剩余:" + (--ticketNum));
    }
}