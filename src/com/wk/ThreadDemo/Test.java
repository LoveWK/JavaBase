/**
 * FileName:  Test
 * Author:    wangkai_wb
 * Date:      2020/4/23
 * Description:
 */
package com.wk.ThreadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/23
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableThread ct = new CallableThread();
        Future<String> f = es.submit(ct);
        es.shutdown();

        try {
            Thread.sleep(5000);
            System.out.println("主线程等待5秒, 当前时间为" +System.currentTimeMillis());

            String str = f.get();
            System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" +System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
