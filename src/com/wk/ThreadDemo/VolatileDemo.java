/**
 * FileName:  VolatileDemo
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
public class VolatileDemo {
    //使用volatile修饰变量
    private static volatile boolean isStop = false;
    public static void stopIt(){
        isStop = true;
    }

    public static void main(String[] args) {
        new Thread1().start();
        while (!isStop){
        }
        System.out.println("stop!!!");
    }
    static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopIt();
        }
    }
}
