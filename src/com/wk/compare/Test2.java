/**
 * FileName:  Test2
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
public class Test2 {
    public static void main(String[] args) {
        PersonComparator personComparator = new PersonComparator();
        Person p1 = new Person("xiaomi",10);
        Person p2 = new Person("xiaowei",30);
        // 因为使用的是Integer默认实现,所以
        // 如果结果>0,表示p1.get>p2.age;
        // 如果结果=0,表示p1.age = p2.age;
        // 如果结果<0,表示p1.age < p2.age;
        System.out.println("p1和p2比较结果:"+personComparator.compare(p1, p2));
    }
}
