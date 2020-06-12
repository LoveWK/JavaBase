/**
 * FileName:  UserDto
 * Author:    wangkai_wb
 * Date:      2020/6/11
 * Description: UserDto
 */
package com.wk.stream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈UserDto〉
 *
 * @author wangkai_wb
 * @create 2020/6/11
 * @since 1.0.0
 */
public class UserDto {
    //客户编号
    private int userId;
    //客户姓名
    private String userName;
    //客户年龄
    private int age;
    //客户性别
    private int gender;
    //客户手机号
    private String phone;
    //客户地址
    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
