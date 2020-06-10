/**
 * FileName:  ARunnable
 * Author:    wangkai_wb
 * Date:      2020/5/8
 * Description:
 */
package com.wk.ThreadDemo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/5/8
 * @since 1.0.0
 */
public class ARunnable {
    public static void main(String[] args) {
        myRunnable myRunnable = new myRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
class myRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("current thread name"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
