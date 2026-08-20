import java.util.*;

/**
 * List Set Map 基础练习
 * List：有序、可重复
 * Set：无序、不可重复
 * Map：键值对，key不可重复
 */
public class CollectionBasicDemo {
    public static void main(String[] args) {
        testList();
        System.out.println("------------------------");
        testSet();
        System.out.println("------------------------");
        testMap();
        System.out.println("------------------------");
        practiceExercise();
    }

    /**
     * List 练习：ArrayList 为主，有序、允许重复，支持下标访问
     */
    public static void testList() {
        List<String> list = new ArrayList<>();
        // 新增
        list.add("苹果");
        list.add("香蕉");
        list.add("橙子");
        list.add("苹果"); // List允许重复元素

        System.out.println("List全部元素：" + list);
        System.out.println("下标1获取：" + list.get(1));

        // 修改
        list.set(2, "葡萄");
        System.out.println("修改下标2后：" + list);

        // 删除
        list.remove("香蕉");
        System.out.println("删除香蕉后：" + list);

        // 三种遍历方式
        System.out.print("for循环遍历：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.print("增强for遍历：");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("迭代器Iterator遍历：");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");
    }

    /**
     * Set练习：HashSet，元素不可重复，无序
     */
    public static void testSet() {
        Set<String> set = new HashSet<>();
        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("张三"); // 重复元素，不会存入

        System.out.println("Set集合：" + set);
        System.out.println("集合大小：" + set.size());

        // 判断是否包含
        System.out.println("是否包含李四：" + set.contains("李四"));

        // 删除
        set.remove("王五");
        System.out.println("删除王五后：" + set);

        // Set没有下标，只能增强for / 迭代器遍历
        System.out.print("Set增强for遍历：");
        for (String name : set) {
            System.out.print(name + " ");
        }
        System.out.println("\n");
    }

    /**
     * Map练习：HashMap，key‑value，key唯一
     */
    public static void testMap() {
        Map<Integer, String> map = new HashMap<>();
        // put 添加/修改
        map.put(1, "Java");
        map.put(2, "MySQL");
        map.put(3, "Maven");
        map.put(2, "Spring"); // key重复，覆盖旧value

        System.out.println("Map集合：" + map);
        System.out.println("key=2获取value：" + map.get(2));

        // 判断key、value是否存在
        System.out.println("是否存在key 3：" + map.containsKey(3));
        System.out.println("是否存在value Java：" + map.containsValue("Java"));

        // 删除
        map.remove(3);
        System.out.println("删除key=3后：" + map);

        // Map三种遍历
        System.out.println("===== keySet遍历（拿key，再get值）");
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println("key:" + key + " value:" + map.get(key));
        }

        System.out.println("===== entrySet遍历（最高效）");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        System.out.println("===== 只遍历value");
        Collection<String> values = map.values();
        for (String v : values) {
            System.out.print(v + " ");
        }
        System.out.println("\n");
    }

    /**
     * 综合小练习题
     * 需求：
     * 1. 有一批带重复的数字，用List接收
     * 2. 使用Set对List去重
     * 3. Map统计每个数字出现多少次
     */
    public static void practiceExercise() {
        System.out.println("========综合练习题：数字去重+统计次数========");
        List<Integer> numList = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        System.out.println("原始list：" + numList);

        // Set去重
        Set<Integer> numSet = new HashSet<>(numList);
        System.out.println("Set去重后：" + numSet);

        // Map统计每个数字出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : numList) {
            if (countMap.containsKey(num)) {
                // key存在，次数+1
                countMap.put(num, countMap.get(num) + 1);
            } else {
                // key不存在，初始化次数=1
                countMap.put(num, 1);
            }
        }
        System.out.println("各数字出现次数：" + countMap);
    }
}