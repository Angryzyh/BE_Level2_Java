package interface_and_abstract.abstract_;

abstract class Animal {
    private int age = 10;
    public Animal(){
        System.out.println("初始化Animal");
    }
    public void move(){
        System.out.println("跑步数："+this.age);
    }
}

abstract class Dog extends Animal{
    public Dog(int age){
        //super(); //隐式调用
        // super(age);//去掉会报异常
        System.out.println("初始化Dog");
    }

}

class BigDogs extends Dog{
    public BigDogs(){
        super(20);
        System.out.println("初始化BigDog");
    }
    public static void main(String[] args){
        BigDogs a = new BigDogs();
        a.move();
    }
}
