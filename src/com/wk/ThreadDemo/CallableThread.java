/**
 * FileName:  CallableThread
 * Author:    wangkai_wb
 * Date:      2020/4/23
 * Description:
 */
package com.wk.ThreadDemo;

import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/23
 * @since 1.0.0
 */
public class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("进入CallableThread的call()方法, 开始睡觉, 睡觉时间为" +System.currentTimeMillis());
        Thread.sleep(10000);
        return "123";
    }
}
