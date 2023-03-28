package interface_and_abstract.abstract_;

public class son1 extends father1 {
    /* 1.静态代码，在虚拟机加载类的时候就会加载执行，而且只执行一次；
        非静态代码，在创建对象的时候（即new 一个对象的时候）执行，每次创建对象都会执行一次。
       2.执行顺序，静态代码块 -> 非静态代码块 -> 构造方法*/
    {
        System.out.println("son1代码块");
    }

    static {
        System.out.println("son1静态代码块");
    }

    public son1() {
        System.out.println("调用了son1无参构造方法");
    }

    public son1(Integer id, String name) {
        super(id, name);
        System.out.println("调用了son1全参构造方法");
    }

    public static void main(String[] args) {
        gf1 a = new son1(1,"小趴菜");
        father1 b = new son1(2, "大趴菜");
        a.speak();
        b.speak();
        b.hello(10);
        System.out.println("*************************************************");
        a.hello1();
        b.hello1(20);
        a.run();
        a.run1();
        a.speak();
        a.speak1();
        System.out.println("*************************************************");

    }

    @Override
    public void hello1() {
        System.out.println("重写hello1");
    }


    @Override
    public void hello1(int x) {
        System.out.println("重写hello1了"+x+"次");
    }

    @Override
    protected void speak1() {
        System.out.println("重写speak1");
    }

    @Override
    void run1() {
        System.out.println("重写run1");
    }
}

