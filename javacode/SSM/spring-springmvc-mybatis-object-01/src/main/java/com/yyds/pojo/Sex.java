package com.yyds.pojo;

public class Sex {
    private int id;
    private String sex;

    public Sex() {
    }

    public Sex(int id, String sex) {
        this.id = id;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }
}
