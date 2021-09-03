package com.yyds.pojo;

public class User {
    private int id;
    private String code;
    private String user_name;
    private String password;
    private int sex;
    private int age;
    private String tel_number;
    private int roleId;

    public User() {
    }

    public User(int id, String code, String user_name, String password, int sex, int age, String tel_number, int roleId) {
        this.id = id;
        this.code = code;
        this.user_name = user_name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.tel_number = tel_number;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", tel_number='" + tel_number + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
