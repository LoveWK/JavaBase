/**
 * FileName:  ExecutorsDemo
 * Author:    wangkai_wb
 * Date:      2020/5/9
 * Description:
 */
package com.wk.ThreadDemo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/5/9
 * @since 1.0.0
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        int cpuCoreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("cpuCoreCount:"+cpuCoreCount);
        AThreadFactory aThreadFactory = new AThreadFactory();
        ARunnable1 aRunnable = new ARunnable1();
        //固定大小线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cpuCoreCount,aThreadFactory);
        //无界线程池,可以进行自动线程回收
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool(aThreadFactory);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(cpuCoreCount,aThreadFactory);
        //单个后台线程
        ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor(aThreadFactory);
        System.out.println("fixedThreadPool:"+fixedThreadPool.toString());
        fixedThreadPool.submit(aRunnable);
        System.out.println("fixedThreadPool:"+fixedThreadPool.toString());
        cacheThreadPool.submit(aRunnable);
        newScheduledThreadPool.scheduleAtFixedRate(aRunnable,0,1,TimeUnit.SECONDS);
        singleThreadExecutor.scheduleWithFixedDelay(aRunnable,0,100,TimeUnit.MILLISECONDS);
        System.out.println("开始等待...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待结束...");
        fixedThreadPool.shutdownNow();
        cacheThreadPool.shutdownNow();
        newScheduledThreadPool.shutdownNow();
        singleThreadExecutor.shutdownNow();

    }
}
class ARunnable1 implements Runnable{

    @Override
    public void run() {
        System.out.println("进入run方法...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current Thread Name:"+Thread.currentThread().getName());
    }
}
//创建线程工厂
class AThreadFactory implements ThreadFactory{

    private final AtomicInteger threadNumber = new AtomicInteger(1);
    @Override
    public Thread newThread(Runnable r) {
        return new Thread("aThread-"+threadNumber.incrementAndGet());
    }
}

