import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * 自定义注解，元注解，反射读取注解
 */
public class AnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<DemoService> clazz = DemoService.class;
        MyAnno classAnno = clazz.getAnnotation(MyAnno.class);
        System.out.println("类注解value:"+classAnno.value());

        Method method = clazz.getDeclaredMethod("test");
        MyAnno methodAnno = method.getAnnotation(MyAnno.class);
        System.out.println("方法注解value:"+methodAnno.value());
    }

    //自定义注解
    @Target({ElementType.TYPE,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface MyAnno{
        String value() default "default";
    }

    @MyAnno(value = "标记类")
    static class DemoService{
        @MyAnno(value = "标记方法")
        public void test(){}
    }
}