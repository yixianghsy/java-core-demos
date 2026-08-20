import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射练习：获取Class对象，操作私有字段、调用方法 JDK8
 */
public class ReflectBasicDemo {
    public static void main(String[] args) throws Exception {
        //三种获取Class
        Class<User> clazz1 = User.class;
        // 方式2：对象实例getClass，强转消除类型警告
        Class<?> clazz2 = new User("张三",20).getClass();
        // 内部类完整类名，注意$符号，不是 .
        Class<?> clazz3 = Class.forName("ReflectBasicDemo$User");

        //获取带(String,int)参数的构造器
        Constructor<User> con = clazz1.getDeclaredConstructor(String.class,int.class);
        User user = con.newInstance("张三",20);
        System.out.println(user);

        //反射读取私有字段
        Field nameField = clazz1.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("反射拿私有name:"+nameField.get(user));

        //反射调用方法
        Method setAge = clazz1.getDeclaredMethod("setAge", int.class);
        setAge.invoke(user,22);
        System.out.println("修改后对象:"+user);
    }

    static class User{
        private String name;
        private int age;
        public User(String name,int age){
            this.name = name;
            this.age = age;
        }
        public void setAge(int age){ this.age = age; }
        @Override
        public String toString() { return "User{name='"+name+"',age="+age+"}"; }
    }
}