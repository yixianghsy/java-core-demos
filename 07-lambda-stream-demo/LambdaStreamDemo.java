import java.util.*;
import java.util.stream.Collectors;

/**
 * Lambda表达式 + Stream流练习
 */
public class LambdaStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5,2,8,2,9,3,5);

        // lambda
        list.forEach(x-> System.out.print(x+" "));
        System.out.println("\n====Stream====");

        List<Integer> res = list.stream()
                .filter(x->x>3)
                .distinct()
                .sorted()
                .map(x->x*2)
                .collect(Collectors.toList());
        System.out.println(res);

        //统计
        long count = list.stream().filter(x->x>3).count();
        System.out.println("大于3元素数量:"+count);

        //分组
        List<String> strList = Arrays.asList("apple","banana","apricot","berry");
        Map<Character,List<String>> groupMap = strList.stream()
                .collect(Collectors.groupingBy(s->s.charAt(0)));
        System.out.println("按首字母分组:"+groupMap);
    }
}