/**
 * FileName:  FailFastDemo
 * Author:    wangkai_wb
 * Date:      2020/4/24
 * Description: 集合的异常处理机制
 */
package com.wk.failFastDemo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈集合的异常处理机制〉
 *
 * @author wangkai_wb
 * @create 2020/4/24
 * @since 1.0.0
 */
public class FailFastDemo {
//    private static List<String> list = new ArrayList<String>();
    //使用CopyOnWriteArrayList替代ArrayList
    private static List<String> list = new CopyOnWriteArrayList<String>();
    public static void main(String[] args) {
        //两个线程对同一个ArrayList进行操作
        new ThreadOne().start();
        new ThreadTwo().start();
    }
    //输出list中的值
    private static void printAll(){
        try {
            String value = null;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                value = (String) iterator.next();
                System.out.println("list 中的值:"+value);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //线程一:向list中依次添加数据,然后printAll整个list
    private static class ThreadOne extends Thread{
        public void run() {
            for (int i = 0; i < 6; i++) {
                list.add(String.valueOf("线程一:Java的架构师技术栈"+i));
                printAll();
            }
        }
    }
    //线程二:对ArrayList进行同样的操作
    private static class ThreadTwo extends Thread{
        public void run() {
            for (int i = 0; i < 6; i++) {
                list.add(String.valueOf("线程二:Java的架构师技术栈"+i));
                printAll();
            }
        }
    }
}
