package thread.deadlock;

/**
 * 死锁实例
 */
public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T(true);
        T t2 = new T(false);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(t1.getName()+":"+t1.getState());
        System.out.println(t2.getName()+":"+t2.getState());
    }
}

class T extends Thread {
    private Boolean flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    T(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName()+" 1 step");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName()+" 2 step");
                }
            }
        }
        else{
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+" 3 step");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+" 4 step");
                }
            }
        }
    }
}


