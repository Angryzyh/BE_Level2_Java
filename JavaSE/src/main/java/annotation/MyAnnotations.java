package annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Inherited
@Documented
public @interface MyAnnotations {
    MyAnnotation[] value();
}
