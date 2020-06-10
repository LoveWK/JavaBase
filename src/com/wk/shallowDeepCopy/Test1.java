/**
 * FileName:  Test1
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
public class Test1 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10);
        student.setName("jiumeng");
        Teacher teacher1 = new Teacher();
        teacher1.setGrad(1);
        teacher1.setName("teacherma");
        teacher1.setStudent(student);
        System.out.println("teacher1:"+teacher1.toString());
        Teacher teacher2 = new Teacher();
        teacher2 = teacher1;
        System.out.println("teacher2:"+teacher2.toString());
        System.out.println("========================");
        teacher2.setName("teacherbai");
        teacher2.setGrad(2);
        System.out.println("teacher1:"+teacher1.toString());
        System.out.println("teacher2:"+teacher2.toString());
    }
}
