package interface_and_abstract.interface_;

public interface gf1 {
    public static final int ID = 0;
    public static final String NAME = null;

    //静态方法
    public static void speak1(){
        System.out.println("static_gf1_speak");
    }

    //默认方法
    public default void speak2(){
        System.out.println("default_gf1_speak");
    }

    //接口抽象方法
    void speak3();
}
