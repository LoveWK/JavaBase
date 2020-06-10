/**
 * FileName:  ThreadCount
 * Author:    wangkai_wb
 * Date:      2020/5/15
 * Description:
 */
package com.wk.ThreadDemo;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/5/15
 * @since 1.0.0
 */
public class ThreadCount {
    private static ExecutorService executorService = new ThreadPoolExecutor(50,
            100,0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(100000));

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100000; i++) {
            executorService.execute(()->{
                System.out.println(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
        while (true){
            System.out.println("--");
            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("当前排队线程数:"+queueSize);

            int activeCount = threadPoolExecutor.getActiveCount();
            System.out.println("当前活动线程数:"+activeCount);

            long completeTaskCount = threadPoolExecutor.getCompletedTaskCount();
            System.out.println("执行完成线程数:"+completeTaskCount);

            long taskCount = threadPoolExecutor.getTaskCount();
            System.out.println("总线程数:"+taskCount);

            Thread.sleep(3000);
        }
    }

}
