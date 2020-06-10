/**
 * FileName:  TestShallowCopy
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
public class TestShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        StudentPro1 studentPro1 = new StudentPro1();
        studentPro1.setName("studentProA");
        studentPro1.setAge(100);
        TeacherPro1 teacherPro1 = new TeacherPro1();
        teacherPro1.setStudentPro1(studentPro1);
        teacherPro1.setGrad(1);
        teacherPro1.setName("teacherA");
        TeacherPro1 teacherPro2 = (TeacherPro1) teacherPro1.clone();
        teacherPro2.setName("teacherB");
        teacherPro2.setGrad(2);
        StudentPro1 studentPro2 = teacherPro2.getStudentPro1();
        studentPro2.setName("studentProB");
        studentPro2.setAge(200);
        System.out.println("teacher1:"+teacherPro1.toString());
        System.out.println("teacher2:"+teacherPro2.toString());

    }
}
