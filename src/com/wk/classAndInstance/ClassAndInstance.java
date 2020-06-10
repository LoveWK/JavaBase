/**
 * FileName:  ClassAndInstance
 * Author:    wangkai_wb
 * Date:      2020/4/22
 * Description:
 */
package com.wk.classAndInstance;

/**
 * 〈一句话功能简述〉<br> 
 * 〈class和instance的区别〉
 *
 * @author wangkai_wb
 * @create 2020/4/22
 * @since 1.0.0
 */
public class ClassAndInstance {

    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        System.out.println(a.getClass());
        System.out.println(b.getClass());

        System.out.println(b.getClass().equals(A.class));
        System.out.println(b.getClass().equals(B.class));

        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
    }

}
