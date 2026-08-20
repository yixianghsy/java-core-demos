import java.util.ArrayList;
import java.util.List;

/**
 * JVM简单练习：OOM模拟，对象内存
 * VM options: ‑Xms10m ‑Xmx10m
 */
public class JvmSimpleTest {
    public static void main(String[] args) {
        //模拟OOM，打开下面注释运行，会抛出java.lang.OutOfMemoryError: Java heap space
//        List<byte[]> list = new ArrayList<>();
//        while(true){
//            list.add(new byte[1024*1024]);
//        }

        System.out.println("JVM最大堆内存:"+Runtime.getRuntime().maxMemory()/1024/1024+" MB");
        System.out.println("JVM空闲内存:"+Runtime.getRuntime().freeMemory()/1024/1024+" MB");
        System.out.println("总内存:"+Runtime.getRuntime().totalMemory()/1024/1024+" MB");
    }
}