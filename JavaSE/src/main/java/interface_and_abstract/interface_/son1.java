package interface_and_abstract.interface_;

public class son1 implements father1 {

    @Override
    public void speak3() {
        System.out.println("实现speak3");
    }

    @Override
    public void eat3() {
        System.out.println("实现eat3");
        
    }

    public static void main(String[] args) {
        father1 son1 = new son1();
        System.out.println("1");
        father1.speak1();
        System.out.println("2");
        son1.speak2();
        System.out.println("3");
        son1.speak3();
        System.out.println("4");
        son1.eat2();
        System.out.println("5");
        son1.eat3();
    }
}
