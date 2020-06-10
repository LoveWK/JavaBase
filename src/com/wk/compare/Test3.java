/**
 * FileName:  Test3
 * Author:    wangkai_wb
 * Date:      2020/4/24
 * Description:
 */
package com.wk.compare;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/24
 * @since 1.0.0
 */
public class Test3 {
    public static void main(String[] args) {
        Student s1 = new Student("ming",8,1);
        Student s2 = new Student("tian",9,2);
        //通过s1 和 s2 的stuNo进行比较
        System.out.println("s1的stuNo-s2的stuNo:"+s1.compareTo(s2));
    }
}
