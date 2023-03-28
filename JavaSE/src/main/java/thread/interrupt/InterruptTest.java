package thread.interrupt;

/**
 * 线程 中断
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("子线程");
        //设置线程最大优先级 为10
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        //主线程 执行五次 开始打断 t线程
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "执行次数:" + i);
        }
        t.interrupt();
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "执行次数:" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "开始休眠20s");
                //休眠20s
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                System.out.println(Thread.currentThread().getName() + "被中断interrupt");
            }
        }
    }
}