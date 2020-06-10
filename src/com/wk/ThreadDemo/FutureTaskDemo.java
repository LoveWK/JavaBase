/**
 * FileName:  FutureTaskDemo
 * Author:    wangkai_wb
 * Date:      2020/5/15
 * Description:
 */
package com.wk.ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/5/15
 * @since 1.0.0
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        ACallAble aCallAble = new ACallAble();
        FutureTask futureTask = new FutureTask(aCallAble);
        Thread thread = new Thread(futureTask);
        thread.start();
        do {

        }while (!futureTask.isDone());
        try {
            Object result = futureTask.get();
            System.out.println("Result:"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
class ACallAble implements Callable{

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return "Thread-Name:"+Thread.currentThread().getName();
    }
}
