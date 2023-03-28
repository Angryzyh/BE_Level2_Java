package thread.state;

/**
 * 测试线程状态
 */
public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + ":当前状态为-->" + t.getState());
        t.start();
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + ":当前状态为-->" + t.getState());
            Thread.sleep(600);
        }
        System.out.println(t.getName() + ":当前状态为-->" + t.getState());
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("hi~~~"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
