package annotation;

@MyAnnotation("你好")
//@MyAnnotations({@MyAnnotation(value = "111"), @MyAnnotation(value = "222")})  //jdk8之前重复注解
@MyAnnotation("大家好")
public class Test01 {
    public static void main(String[] args) {
        int i = (@MyAnnotation int) 10.0f;
    }
}
