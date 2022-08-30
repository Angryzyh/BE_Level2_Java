package enum_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String email;
    @Getter
    @AllArgsConstructor
    enum Sex {
        //public static final Sex WOMAN =new Sex(0,"女");  原本自定义class枚举类,这样new对象
        //public static final Sex MAN =new Sex(1,"男");
        WOMAN(0,"女"),
        MAN(1,"男");
        private Integer sexCode;
        private String sexName;
    }
}

class testUser{
    public static void main(String[] args) {
        test2();
    }

    private static void test0() {
        User user = new User();
        user.setUid(1);
        user.setUsername("张三");
        user.setPassword("331413");
        user.setSex(User.Sex.MAN.getSexName());
        System.out.println("user = " + user);
    }

    //Sex.values() 枚举类方法,获取枚举类名称
    public static void test1() {
        User.Sex[] values = User.Sex.values();
        for (User.Sex value : values) {
            System.out.println("value = " + value);
        }
    }

    // Enum.valueOf("XXX")  //获取名称为"XXX"的 枚举对象
    public static void test2() {
        User.Sex woman = User.Sex.valueOf("WOMAN");
        System.out.println("woman = " + woman +"|"+ woman.getSexCode()+"|"+ woman.getSexName());
    }
}
