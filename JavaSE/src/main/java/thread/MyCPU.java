package thread;

/**
 * 获得当前电脑的cpu数量
 */
public class MyCPU {
    public static void main(String[] args) {

        // cpu数量
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors= " + i);

        //内存信息
        long l = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory= " + l / 1024 / 1024);
        long l1 = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory= " + l1 / 1024 / 1024);
        long l2 = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory = " + l2 / 1024 / 1024);
    }
}