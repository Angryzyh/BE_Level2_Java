package reflect.pojo;

public class Cat {
    public String name = "小黑猫";

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hi() {
        System.out.println(this.name+":喵 喵 喵~~~");
    }

    public void cry() {
        System.out.println(this.name+": 喵呜~喵呜~喵呜~");
    }

    public void play() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
