package interface_and_abstract.interface_;

public interface father1 extends gf1,gf2{
    public static final int ID = 0;
    public static final String NAME = null;

    //静态方法
    public static void speak1(){
        System.out.println("static_father1_speak");
    }

    //默认方法
    public default void speak2(){
        System.out.println("default_father1_speak");
    }

    //接口抽象方法
    void speak3();
}
