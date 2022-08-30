package generic;

public class t {

    // 泛型方法
    public <E> E test01(E e) {
        System.out.println("e = " + e);
        return e;
    }
}
