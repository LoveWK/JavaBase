/**
 * FileName:  TestDeepCopy
 * Author:    wangkai_wb
 * Date:      2020/4/30
 * Description:
 */
package com.wk.shallowDeepCopy;

import java.io.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangkai_wb
 * @create 2020/4/30
 * @since 1.0.0
 */
public class TestDeepCopy {
    public static void main(String[] args) {
        StudentPlus studentPlus = new StudentPlus();
        studentPlus.setName("studentPlusA");
        studentPlus.setAge(10);
        TeacherPlus teacherPlus1 = new TeacherPlus();
        teacherPlus1.setName("teacherPlusA");
        teacherPlus1.setGrad(1);
        teacherPlus1.setStudentPlus(studentPlus);
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(teacherPlus1);
            oos.flush();
            ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            TeacherPlus teacherPlus2 = (TeacherPlus) ois.readObject();
            teacherPlus2.setName("teacherPlusB");
            teacherPlus2.setGrad(2);
            StudentPlus studentPlus2 = teacherPlus2.getStudentPlus();
            studentPlus2.setName("studentPlusB");
            studentPlus2.setAge(20);
            System.out.println("teacherPlus1:"+teacherPlus1.toString());
            System.out.println("teacherPlus2:"+teacherPlus2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
