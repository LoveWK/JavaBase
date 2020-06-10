/**
 * FileName:  TestDeepCopy1
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
public class TestDeepCopy1 {
    public static void main(String[] args) throws CloneNotSupportedException{
        StudentPro studentPro1 = new StudentPro();
        studentPro1.setName("studentProA");
        studentPro1.setAge(100);
        TeacherPro teacherPro1 = new TeacherPro();
        teacherPro1.setStudentPro(studentPro1);
        teacherPro1.setGrad(1);
        teacherPro1.setName("teacherA");
        TeacherPro teacherPro2 = (TeacherPro) teacherPro1.clone();
        teacherPro2.setName("teacherB");
        teacherPro2.setGrad(2);
        StudentPro studentPro2 = teacherPro2.getStudentPro();
        studentPro2.setName("studentProB");
        studentPro2.setAge(200);
        System.out.println("teacher1:"+teacherPro1.toString());
        System.out.println("teacher2:"+teacherPro2.toString());
    }
}
