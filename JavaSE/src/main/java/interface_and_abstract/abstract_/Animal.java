package interface_and_abstract.abstract_;

abstract class Animal {
    private int age = 10;
    public Animal(){
        System.out.println("初始化Animal");
    }

    public Animal(int age){
        System.out.println("初始化Animal");
    }

    public void move(){
        System.out.println("跑步数："+this.age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

abstract class Dog extends Animal{
    public Dog(int age){
        // super(); //隐式调用
        // super(age);//去掉会报异常
        System.out.println("初始化Dog");
    }

    public void move(){
        System.out.println("年龄："+this.getAge());
    }

}

class BigDogs extends Dog{
    public BigDogs(){
        super(20);
        System.out.println("初始化BigDog");
    }

    public static void main(String[] args){
        Animal a = new BigDogs();
        a.move();

        Dog b = new BigDogs();
        b.move();
    }
}
