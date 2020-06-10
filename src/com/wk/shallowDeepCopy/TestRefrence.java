/**
 * FileName:  TestRefrence
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
public class TestRefrence {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("studentA");
        student1.setAge(10);
        Teacher teacher1 = new Teacher();
        teacher1.setGrad(1);
        teacher1.setName("teacherA");
        teacher1.setStudent(student1);
        Teacher teacher2 = teacher1;
        teacher2.setGrad(2);
        teacher2.setName("teacherB");
        Student student2 = teacher2.getStudent();
        student2.setName("teacherB");
        student2.setAge(20);
        System.out.println("teacher1:"+teacher1.toString());
        System.out.println("teacher2:"+teacher2.toString());
    }
}
