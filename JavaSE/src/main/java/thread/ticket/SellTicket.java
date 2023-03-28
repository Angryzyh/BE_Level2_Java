package thread.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
    模拟 三个窗口售票 , 通过继承创建多线程
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
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("票已售空");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "窗口:卖出了一张票,还剩余:" + (--ticketNum));
        }
    }
}

class R implements Runnable {
    public static int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("票已售空");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "窗口:卖出了一张票,还剩余:" + (--ticketNum));
        }
    }
}