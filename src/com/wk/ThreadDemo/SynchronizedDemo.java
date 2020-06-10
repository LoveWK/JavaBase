/**
 * FileName:  SynchronizedDemo
 * Author:    wangkai_wb
 * Date:      2020/5/14
 * Description:
 */
package com.wk.ThreadDemo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/5/14
 * @since 1.0.0
 */
public class SynchronizedDemo {
    //使用volatile修饰变量
    private static volatile int n = 0;
    public static synchronized void add(){
        n++;
    }

    public static void main(String[] args) {
        new Thread1().start();
        while (n<100){

        }
        System.out.println("stop");
    }
    static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 200; i++) {
                add();
            }
        }
    }
}
