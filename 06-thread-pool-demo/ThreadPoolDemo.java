import java.util.concurrent.*;

/**
 * 线程池练习：Executors快速创建、ThreadPoolExecutor手动创建、submit/execute
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.快速创建线程池（不推荐生产使用，仅练习）
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for(int i=0;i<5;i++){
            int idx = i;
            pool.submit(()->{
                System.out.println("任务"+idx+" 执行线程:"+Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }

        // 2.手动创建标准线程池（生产推荐）
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        Future<Integer> future = executor.submit(()->{
            Thread.sleep(300);
            return 888;
        });
        System.out.println("获取返回值:"+future.get());

        pool.shutdown();
        executor.shutdown();
    }
}