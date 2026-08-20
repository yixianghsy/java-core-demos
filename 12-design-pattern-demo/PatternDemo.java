/**
 * 常用设计模式小样：单例、工厂、策略
 */
public class PatternDemo {
    public static void main(String[] args) {
        //单例
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("单例是否同一个对象:"+(s1==s2));

        //简单工厂
        Product productA = ProductFactory.create("A");
        productA.doWork();

        //策略模式
        Strategy add = (a,b)->a+b;
        System.out.println("策略计算:"+add.calc(3,5));
    }

    //饿汉单例
    static class Singleton{
        private static final Singleton INSTANCE = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){ return INSTANCE; }
    }

    //简单工厂
    interface Product{ void doWork(); }
    static class ProductA implements Product{ @Override public void doWork(){ System.out.println("产品A工作"); } }
    static class ProductB implements Product{ @Override public void doWork(){ System.out.println("产品B工作"); } }
    static class ProductFactory{
        public static Product create(String type){
            if("A".equals(type)) return new ProductA();
            else return new ProductB();
        }
    }

    //策略模式
    @FunctionalInterface
    interface Strategy{ int calc(int a,int b); }
}