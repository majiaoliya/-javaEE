package com.icis.pojo;

import java.util.Date;

//封装用户数据
public class User {
    int id;
    private String username;
    private String password;
    private String email,
                    qq,
                    tel,
                    gender,
                    sex,
                    age,
                    checkcode,
                    address;
    private Date birthday;

    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        System.out.println("set birth:" + birthday);
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", sex='" + sex + '\'' +
                ", checkcode='" + checkcode + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(int id, String username, String password, String email, String tel, String gender, String checkcode, Date birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.gender = gender;
        this.checkcode = checkcode;
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
