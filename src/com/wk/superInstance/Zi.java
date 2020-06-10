/**
 * FileName:  Zi
 * Author:    wangkai_wb
 * Date:      2020/4/22
 * Description: 子类
 */
package com.wk.superInstance;

/**
 * 〈一句话功能简述〉<br> 
 * 〈子类〉
 *
 * @author wangkai_wb
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Zi extends Fu {
    int num = 8;
    Zi(){
        super();
        System.out.println("zi cons run ..."+num);
        return;
    }
    void show1(){
        System.out.println("zi show ..."+num);
    }
}
