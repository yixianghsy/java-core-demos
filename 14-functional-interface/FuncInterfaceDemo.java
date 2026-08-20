import java.util.function.*;

/**
 * JDK内置四大核心函数式接口
 * Consumer、Supplier、Function、Predicate
 */
public class FuncInterfaceDemo {
    public static void main(String[] args) {
        //Consumer 消费，有参无返回
        Consumer<String> consumer = s-> System.out.println("消费:"+s);
        consumer.accept("hello");

        //Supplier 供给，无参有返回
        Supplier<Integer> supplier = ()->100;
        System.out.println("供给:"+supplier.get());

        //Function 转换，有参有返回
        Function<Integer,String> func = x->"数字:"+x;
        System.out.println(func.apply(66));

        //Predicate 判断，返回boolean
        Predicate<Integer> pred = x->x>10;
        System.out.println("大于10? "+pred.test(15));
    }
}