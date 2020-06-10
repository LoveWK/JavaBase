/**
 * FileName:  Teacher
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
public class Teacher {
    //基本数据类型
    private int grad;
    //内部引用类型
    private String name;
    //外部引用类型
    private Student student;

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{hashCode:" + this.hashCode() +" "+
                "grad=" + grad +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
