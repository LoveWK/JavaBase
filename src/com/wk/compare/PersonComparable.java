/**
 * FileName:  PersonComparable
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
public class PersonComparable implements Comparable<Person> {
    private String name;
    private int age;

    public PersonComparable(String name, int age){
        this.age = age;
        this.name = name;
    }


    //排序规则,自己实现排序逻辑
    @Override
    public int compareTo(Person o) {
        //使用age进行排序
        return this.age - o.getAge();
    }
}
