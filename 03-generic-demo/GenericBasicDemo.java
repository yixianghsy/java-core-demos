import java.util.ArrayList;
import java.util.List;

/**
 * Java泛型练习
 * 核心作用：编译期类型检查，避免类型强转，消除Object接收带来的类型转换异常
 */
public class GenericBasicDemo {
    public static void main(String[] args) {
        testNoGeneric();
        System.out.println("------------------------");
        testGenericClass();
        System.out.println("------------------------");
        testGenericMethod();
        System.out.println("------------------------");
        testGenericWildcard();
        System.out.println("------------------------");
        practiceExercise();
    }

    /**
     * 不使用泛型的弊端：存Object，取出需要强转，容易ClassCastException
     */
    public static void testNoGeneric() {
        ArrayList list = new ArrayList();
        list.add(100);
        list.add("hello");

        // 运行时才报错，编译不报错
        Object obj = list.get(0);
        System.out.println("无泛型取出对象：" + obj);
    }

    // ===================== 1. 泛型类 =====================
    /**
     * 泛型类：自定义一个容器，T代表未知类型
     * @param <T> 类型参数，约定常用字母 T Type，E Element，K Key，V Value
     */
    static class MyContainer<T> {
        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static void testGenericClass() {
        // 指定T为String
        MyContainer<String> strContainer = new MyContainer<>();
        strContainer.setData("泛型字符串");
        String str = strContainer.getData();
        System.out.println("泛型类 String：" + str);

        // 指定T为Integer
        MyContainer<Integer> intContainer = new MyContainer<>();
        intContainer.setData(666);
        Integer num = intContainer.getData();
        System.out.println("泛型类 Integer：" + num);

        // 泛型只能用引用类型，不能写基本类型 MyContainer<int> 编译报错
    }

    // ===================== 2. 泛型方法 =====================
    /**
     * 泛型方法：方法上定义 <T>，可以在普通类中使用，不依赖类的泛型
     * @param t 传入任意类型对象
     * @return 返回原对象
     */
    public static <T> T show(T t) {
        System.out.println("泛型方法打印：" + t);
        return t;
    }

    /**
     * 泛型方法：数组转List
     */
    public static <E> List<E> arrayToList(E[] array) {
        List<E> list = new ArrayList<>();
        for (E e : array) {
            list.add(e);
        }
        return list;
    }

    public static void testGenericMethod() {
        show(123);
        show("Java泛型");
        show(3.14);

        String[] arr = {"A", "B", "C"};
        List<String> list = arrayToList(arr);
        System.out.println("数组转List：" + list);
    }

    // ===================== 3. 泛型通配符 ? =====================
    public static void printAll(List<?> list) {
        // ? 代表任意未知类型，只能读取，不能add(除null外)
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    /**
     * ? extends T 上界通配符：只能接收T以及T的子类；【读可以，写不行】
     */
    public static void printNumberList(List<? extends Number> list) {
        for (Number number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /**
     * ? super T 下界通配符：接收T以及T的父类；【可以写，读取只能Object】
     */
    public static void addInteger(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void testGenericWildcard() {
        List<String> strList = new ArrayList<>();
        strList.add("张三");
        strList.add("李四");
        printAll(strList);

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        printNumberList(intList);

        List<Number> numList = new ArrayList<>();
        addInteger(numList);
        System.out.println("super之后：" + numList);
    }

    // ===================== 综合小练习 =====================
    /**
     * 练习需求：
     * 1.写泛型方法，返回集合中第一个元素
     * 2.体会泛型擦除：运行时泛型信息被擦除为Object
     */
    public static void practiceExercise() {
        System.out.println("\n========综合练习========");
        List<String> nameList = new ArrayList<>();
        nameList.add("小明");
        nameList.add("小红");
        String first = getFirst(nameList);
        System.out.println("集合第一个元素：" + first);

        // 泛型擦除：编译后 List<String> 变成 List<Object>
        ArrayList<String> sList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();
        System.out.println("泛型擦除后Class相同：" + (sList.getClass() == iList.getClass()));
    }

    /**
     * 获取集合第一个元素的泛型方法
     */
    public static <E> E getFirst(List<E> list) {
        if(list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}