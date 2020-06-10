/**
 * FileName:  Fu
 * Author:    wangkai_wb
 * Date:      2020/4/22
 * Description: 父类
 */
package com.wk.superInstance;

/**
 * 〈一句话功能简述〉<br> 
 * 〈父类〉
 *
 * @author wangkai_wb
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Fu {
    Fu(){
        super();
        show();
        return;

    }
    void show(){
        System.out.println("fu show");
    }
}
