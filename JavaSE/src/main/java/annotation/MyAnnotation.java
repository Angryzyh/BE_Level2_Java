package annotation;

import java.lang.annotation.*;


//@Retention(RetentionPolicy.SOURCE)  //在源文件保留,编译器直接丢弃
//@Retention(RetentionPolicy.CLASS) //Retention(保留),默认RetentionPolicy.CLASS,class文件中保留,java程序运行时丢弃该注解
@Retention(RetentionPolicy.RUNTIME) //在运行时有效(运行保留), 程序可以通过反射获取该注解
// ==============================================================================
/*
    ElementType[]   //枚举
    TYPE,    类,接口,抽象类,枚举
    FIELD,   成员变量
    METHOD,  方法
    PARAMETER,   方法形参
    CONSTRUCTOR,   构造方法
    LOCAL_VARIABLE,  局部变量
    ANNOTATION_TYPE,  注解
    PACKAGE,      包
    TYPE_PARAMETER,  泛型
    TYPE_USE;      全部可用
* */
@Target({ElementType.TYPE_USE})  //注解可使用的位置
@Documented // 文档注解
@Inherited // 注解可以继承
@Repeatable(MyAnnotations.class) // 可重复注解
public @interface MyAnnotation {
    String[] value() default "默认值";
}
