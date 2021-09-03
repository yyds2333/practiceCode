package com.yyds.pojo;

import org.springframework.stereotype.Component;

@Component
public class Laboratory {
    private int id;
    private String code;
    private String lab_name;
    private int department;//所属院系
    private int today_m=0;//当日预约情况
    private int today_a=0;
    private int today_n=0;
    private int tom_m=0;//次日预约情况
    private int tom_a=0;
    private int tom_n=0;
    private String principal;//教室负责人
    private String capacity;//教室容量

    public Laboratory() {
    }

    public Laboratory(int id, String code, String lab_name, int department, int today_m, int today_a, int today_n, int tom_m, int tom_a, int tom_n, String principal, String capacity) {
        this.id = id;
        this.code = code;
        this.lab_name = lab_name;
        this.department = department;
        this.today_m = today_m;
        this.today_a = today_a;
        this.today_n = today_n;
        this.tom_m = tom_m;
        this.tom_a = tom_a;
        this.tom_n = tom_n;
        this.principal = principal;
        this.capacity = capacity;
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

    public String getName() {
        return lab_name;
    }

    public void setName(String name) {
        this.lab_name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getToday_m() {
        return today_m;
    }

    public void setToday_m(int today_m) {
        this.today_m = today_m;
    }

    public int getToday_a() {
        return today_a;
    }

    public void setToday_a(int today_a) {
        this.today_a = today_a;
    }

    public int getToday_n() {
        return today_n;
    }

    public void setToday_n(int today_n) {
        this.today_n = today_n;
    }

    public int getTom_m() {
        return tom_m;
    }

    public void setTom_m(int tom_m) {
        this.tom_m = tom_m;
    }

    public int getTom_a() {
        return tom_a;
    }

    public void setTom_a(int tom_a) {
        this.tom_a = tom_a;
    }

    public int getTom_n() {
        return tom_n;
    }

    public void setTom_n(int tom_n) {
        this.tom_n = tom_n;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + lab_name + '\'' +
                ", department=" + department +
                ", today_m='" + today_m + '\'' +
                ", today_a='" + today_a + '\'' +
                ", today_n='" + today_n + '\'' +
                ", tom_m='" + tom_m + '\'' +
                ", tom_a='" + tom_a + '\'' +
                ", tom_n='" + tom_n + '\'' +
                ", principal='" + principal + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
