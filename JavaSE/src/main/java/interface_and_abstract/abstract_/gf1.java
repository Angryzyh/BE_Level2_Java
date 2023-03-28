package interface_and_abstract.abstract_;

public abstract class gf1 {
    private Integer id;
    private String name;

    //普通代码块
    {
        System.out.println("gf1普通代码块");
    }

    //静态代码块
    static {
        System.out.println("gf1静态代码块");
    }

    //无参构造方法
    public gf1() {
        System.out.println("调用了gf1无参构造方法");
    }

    //全参构造方法
    public gf1(Integer id, String name) {
        System.out.println("调用了gf1全参构造方法");
        this.id = id;
        this.name = name;
    }

    public void hello() {
        System.out.println(this.getClass().getSimpleName()+":hello");
    }

    protected void speak() {
        System.out.println(this.getClass().getSimpleName()+":说话");
    }

    void run() {
        System.out.println(this.getClass().getSimpleName()+":跑步");
    }

    //父类私有方法子类无法调用
    private void eat() {
        System.out.println(this.getClass().getSimpleName()+":吃饭");
    }

    public abstract void hello1();
    protected abstract void speak1();
    abstract void run1();
    //抽象方法不能私有,因为私有就不能继承
    //private abstract void eat1();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*abstract class gm1 {
        private Integer id;
        private String name;

        {
            System.out.println("gm1代码块");
        }

        //语言级别 '8' 不支持 内部类中的 static 声明
        *//*static {
            System.out.println("gf1静态代码块");
        }*//*

        public gm1() {
        }

        public gm1(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public void hello() {
            System.out.println(this.getClass().getSimpleName()+":hello to gm1");
        }
        protected void speak() {
            System.out.println(this.getClass().getSimpleName()+":说话 with gm1");
        }
        void run() {
            System.out.println(this.getClass().getSimpleName()+":跑步 with gm1");
        }
        //父类私有方法子类无法调用
        private void eat() {
            System.out.println(this.getClass().getSimpleName()+":吃饭 with gm1");
        }

        public abstract void hello1_from_gm1();
        protected abstract void speak1_from_gm1();
        abstract void run1_from_gm1();
    }*/
}
