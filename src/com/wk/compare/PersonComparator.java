/**
 * FileName:  PersonComparator
 * Author:    wangkai_wb
 * Date:      2020/4/24
 * Description:
 */
package com.wk.compare;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/24
 * @since 1.0.0
 */
public class PersonComparator implements Comparator<Person> {
    //排序算法,自己实现排序逻辑
    @Override
    public int compare(Person o1, Person o2) {
        //因为Person对象的age属性使Integer类型的,Integer实现了Comparable接口,实现了compareTo方法
        return o1.getAge().compareTo(o2.getAge());
    }
}
