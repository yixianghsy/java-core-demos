/**
 * 多线程基础：继承Thread、实现Runnable、匿名内部类、线程状态、sleep
 */
public class ThreadBasicDemo {
    public static void main(String[] args) {
        //方式1：继承Thread
        MyThread t1 = new MyThread();
        t1.start();

        //方式2：Runnable接口
        Runnable runnable = ()->{
            for(int i=0;i<5;i++){
                System.out.println("Runnable线程:"+i);
                try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        };
        new Thread(runnable).start();

        //主线程
        for(int i=0;i<5;i++){
            System.out.println("main主线程:"+i);
            try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<5;i++){
                System.out.println("继承Thread线程:"+i);
                try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}