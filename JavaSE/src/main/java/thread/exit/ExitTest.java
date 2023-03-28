package thread.exit;

/**
 * 使用标志位,让线程退出
 */
public class ExitTest {
    public static void main(String[] args) throws InterruptedException {
        // 测试 退出正在运行的线程
        T t = new T();
        t.start();
        Thread.sleep(5 * 1000);
        // 把run方法内的 死循环置为false
        t.setIsExit(false);
        System.out.println("结束分支线程");
    }
}

class T extends Thread {
    private boolean flag = true;
    private int times = 0;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":正在执行!"+(++times));
        }
    }

    public void setIsExit(boolean flag) {
        this.flag = flag;
    }
}
