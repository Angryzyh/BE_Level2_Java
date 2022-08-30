package interface_and_abstract.abstract_;

public abstract class father1 extends gf1{

    {
        System.out.println("father1代码块");
    }

    static {
        System.out.println("father1静态代码块");
    }

    public father1() {
        System.out.println("调用了father1无参构造方法");
    }

    public father1(Integer id, String name) {
        super(id, name);
        System.out.println("调用了father1全参构造方法");
    }

    //重载了父类方法
    public void hello(int i) {
        System.out.println(this.getClass().getSimpleName()+":hello了"+i+"次");
    }
    protected void speak() {
        System.out.println(this.getClass().getSimpleName()+":说话+");
    }
    void run() {
        System.out.println(this.getClass().getSimpleName()+":跑步+");
    }
    //父类私有方法子类无法调用
    private void eat() {
        System.out.println(this.getClass().getSimpleName()+":吃饭+");
    }

    public abstract void hello1(int x);
    protected abstract void speak1();
    abstract void run1();
}
