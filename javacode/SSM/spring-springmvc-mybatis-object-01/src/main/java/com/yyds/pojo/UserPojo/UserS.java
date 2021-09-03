package com.yyds.pojo.UserPojo;

public class UserS {
    private int id;
    private String code;
    private String user_name;
    private String password;
    private String sex;
    private int age;
    private String tel_number;
    private String roleId;

    public UserS() {
    }

    public UserS(int id, String code, String user_name, String password, String sex, int age, String tel_number, String roleId) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserS{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel_number='" + tel_number + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
