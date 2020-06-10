/**
 * FileName:  Student
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
public class Student implements Comparable<Student>{
    private String name;
    private Integer age;
    private int stuNo;

    public Student(String name,Integer age,int stuNo){
        this.name = name;
        this.age = age;
        this.stuNo = stuNo;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    //和自己比较
    @Override
    public int compareTo(Student o) {
        return this.stuNo - o.getStuNo();
    }
}
