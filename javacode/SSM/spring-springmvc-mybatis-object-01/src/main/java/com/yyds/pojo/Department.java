package com.yyds.pojo;

import org.springframework.stereotype.Component;

@Component
public class Department {
    private int id;
    private String code;
    private String depart_name;

    public Department() {
    }

    public Department(int id, String code, String depart_name) {
        this.id = id;
        this.code = code;
        this.depart_name = depart_name;
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

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", depart_name='" + depart_name + '\'' +
                '}';
    }
}
