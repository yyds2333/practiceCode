package com.yyds.pojo.laboratoryPojo;

import org.springframework.stereotype.Component;

@Component
public class LaboratoryJ {
    private int id;
    private String code;
    private String lab_name;
    private String department;//所属院系
    private String today_m = "未预约";//当日预约情况
    private String today_a = "未预约";
    private String today_n = "未预约";
    private String tom_m = "未预约";//次日预约情况
    private String tom_a = "未预约";
    private String tom_n = "未预约";
    private String principal;//教室负责人
    private String capacity;//教室容量

    public LaboratoryJ() {
    }

    public LaboratoryJ(int id, String code, String lab_name, String department, String today_m, String today_a, String today_n, String tom_m, String tom_a, String tom_n, String principal, String capacity) {
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

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getToday_m() {
        return today_m;
    }

    public void setToday_m(String today_m) {
        this.today_m = today_m;
    }

    public String getToday_a() {
        return today_a;
    }

    public void setToday_a(String today_a) {
        this.today_a = today_a;
    }

    public String getToday_n() {
        return today_n;
    }

    public void setToday_n(String today_n) {
        this.today_n = today_n;
    }

    public String getTom_m() {
        return tom_m;
    }

    public void setTom_m(String tom_m) {
        this.tom_m = tom_m;
    }

    public String getTom_a() {
        return tom_a;
    }

    public void setTom_a(String tom_a) {
        this.tom_a = tom_a;
    }

    public String getTom_n() {
        return tom_n;
    }

    public void setTom_n(String tom_n) {
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
        return "LaboratoryJ{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", lab_name='" + lab_name + '\'' +
                ", department='" + department + '\'' +
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
