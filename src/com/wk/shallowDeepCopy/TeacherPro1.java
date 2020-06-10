/**
 * FileName:  TeacherPro1
 * Author:    wangkai_wb
 * Date:      2020/4/30
 * Description:
 */
package com.wk.shallowDeepCopy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/30
 * @since 1.0.0
 */
public class TeacherPro1 implements Cloneable {
    //基本数据类型
    private int grad;
    //内部引用类型
    private String name;
    //外部引用类型
    private StudentPro1 studentPro1;

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

    public StudentPro1 getStudentPro1() {
        return studentPro1;
    }

    public void setStudentPro1(StudentPro1 studentPro1) {
        this.studentPro1 = studentPro1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝
        return super.clone();
    }

    @Override
    public String toString() {
        return "TeacherPro1{teacherpro1:" + this.hashCode() + " "+
                "grad=" + grad +
                ", name='" + name + '\'' +
                ", studentPro1=" + studentPro1 +
                '}';
    }
}
