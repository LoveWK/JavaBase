/**
 * FileName:  TeacherPlus
 * Author:    wangkai_wb
 * Date:      2020/4/30
 * Description:
 */
package com.wk.shallowDeepCopy;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/30
 * @since 1.0.0
 */
public class TeacherPlus implements Serializable {
    //基本数据类型
    private int grad;
    //内部引用类型
    private String name;
    //外部引用类型
    private StudentPlus studentPlus;

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

    public StudentPlus getStudentPlus() {
        return studentPlus;
    }

    public void setStudentPlus(StudentPlus studentPlus) {
        this.studentPlus = studentPlus;
    }

    @Override
    public String toString() {
        return "TeacherPlus{teacherPlus:" + this.hashCode() +" "+
                "grad=" + grad +
                ", name='" + name + '\'' +
                ", studentPlus=" + studentPlus +
                '}';
    }
}
