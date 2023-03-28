package thread.yield_join;

/**
 * 测试 对象.jion()  和   Thread.yield()方法
 * yield()方法涉及到内核态,由cpu调度决定,无法保证是否礼让成功
 */
public class JoinAndYieldTest {
    //主线程和子线程并发执行5次后,再让子线程join先执行完
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行次数:" + i);
            if (i == 5) {
                System.out.println("主线程让子线程插队执行.");
                Thread.yield();
                //t.join();
                System.out.println("子线程执行完毕,主线程恢复执行.");
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行次数:" + i);
        }
    }
}