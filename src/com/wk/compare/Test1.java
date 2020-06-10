/**
 * FileName:  Test1
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
public class Test1 {
    public static void main(String[] args) {
        PersonComparable p1 = new PersonComparable("xiaoming",3);
        Person p11 = new Person("xiaom",5);
        PersonComparable p2 = new PersonComparable("xiaoliang",5);
        Person p22 = new Person("xiaol",4);
        System.out.println("p1和p11的age比较:"+p1.compareTo(p11));
        System.out.println("p2和p22的age比较:"+p2.compareTo(p22));
    }
}
