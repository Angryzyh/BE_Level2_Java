package thread.daemon;

/**
 * 测试守护线程
 * 如果不把 子线程设置成守护线程,
 * 当宝强回家时候,就会发现马蓉和宋喆还在聊天
 */
public class DaemonThreadTest {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在工作~~~");
            Thread.sleep(1000);
        }
        System.out.println("宝强下班回家了!!!!!!!!!!!!!");
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("马蓉和宋喆在聊天~~~");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}