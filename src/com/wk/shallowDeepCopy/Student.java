/**
 * FileName:  Student
 * Author:    wangkai_wb
 * Date:      2020/4/28
 * Description:
 */
package com.wk.shallowDeepCopy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/28
 * @since 1.0.0
 */
public class Student {
    //基本数据类型
    private int age;
    //内部引用类型
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{hashCode:" + this.hashCode() +" "+
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
