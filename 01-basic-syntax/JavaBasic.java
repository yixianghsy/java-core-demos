/**
 * Java基础入门：变量、分支、循环
 */
public class JavaBasic {
    // 程序入口 main方法
    public static void main(String[] args) {
        System.out.println("========== 1. 变量与数据类型 ==========");
        // 基本数据类型
        byte b = 10;
        short s = 100;
        int num = 1000;       // 整型最常用
        long l = 99999L;      // long要加L
        float f = 3.14F;      // float要加F
        double d = 3.14159;
        char ch = 'A';        // 单个字符，单引号
        boolean flag = true;  // true / false
        String str = "Java字符串"; // 引用类型，双引号

        System.out.println("int变量num = " + num);
        System.out.println("字符串：" + str);

        // 常量 final 不可修改
        final double PI = 3.1415926;
        System.out.println("常量PI = " + PI);

        System.out.println("\n========== 2. 分支结构 if else ==========");
        int score = 78;
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        System.out.println("\n========== 3. switch分支 ==========");
        int week = 3;
        switch (week) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            default:
                System.out.println("未知星期");
        }

        System.out.println("\n========== 4. while循环 ==========");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        System.out.println("\n========== 5. do-while循环（至少执行一次） ==========");
        int j = 1;
        do {
            System.out.print(j + " ");
            j++;
        } while (j <= 5);
        System.out.println();

        System.out.println("\n========== 6. for循环（最常用） ==========");
        // for(初始化;条件;更新)
        for (int k = 1; k <= 5; k++) {
            System.out.print(k + " ");
        }
        System.out.println();

        System.out.println("\n========== 7. 嵌套循环：打印九九乘法表简易版 ==========");
        for (int m = 1; m <= 3; m++) {
            for (int n = 1; n <= m; n++) {
                System.out.print(n + "*" + m + "=" + (m * n) + "\t");
            }
            System.out.println();
        }

        System.out.println("\n========== 8. break 和 continue ==========");
        // break：跳出整个循环
        for (int x = 1; x <= 10; x++) {
            if (x == 4) {
                break;
            }
            System.out.print(x + " ");
        }
        System.out.println();

        // continue：跳过本次循环，继续下一次
        for (int x = 1; x <= 5; x++) {
            if (x == 3) {
                continue;
            }
            System.out.print(x + " ");
        }
    }
}