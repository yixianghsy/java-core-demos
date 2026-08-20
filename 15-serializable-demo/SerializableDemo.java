import java.io.*;

/**
 * Java序列化练习，实现Serializable接口
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserSer user = new UserSer(1L,"小明",18);
        //序列化写出
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))){
            oos.writeObject(user);
        }
        //反序列化读入
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
            UserSer read = (UserSer) ois.readObject();
            System.out.println("反序列化对象:"+read);
        }
    }

    static class UserSer implements Serializable{
        private static final long serialVersionUID = 1L;
        private Long id;
        private String name;
        private transient int age; //transient不会序列化

        public UserSer(Long id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "UserSer{id="+id+",name='"+name+"',age="+age+"}";
        }
    }
}