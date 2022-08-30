package interface_and_abstract.interface_;

public interface father2 {
    public static final int ID = 0;
    public static final String NAME = null;

    //静态方法
    public static void eat1(){
        System.out.println("static_father2_eat");
    }

    //默认方法
    public default void eat2(){
        System.out.println("default_father2_eat");
    }

    //接口抽象方法
    void eat3();
}
