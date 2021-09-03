package com.yyds.pojo.laboratoryPojo;

import org.springframework.stereotype.Component;

@Component
public class LabDate {
    private int id;
    private int today_m;//当日预约情况
    private int today_a;
    private int today_n;
    private int tom_m;//次日预约情况
    private int tom_a;
    private int tom_n;

    public LabDate(int id,int today_m, int today_a, int today_n, int tom_m, int tom_a, int tom_n) {
        this.id = id;
        this.today_m = today_m;
        this.today_a = today_a;
        this.today_n = today_n;
        this.tom_m = tom_m;
        this.tom_a = tom_a;
        this.tom_n = tom_n;
    }

    public LabDate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "LabDate{" +
                "id='"+id+'\''+
                "today_m='" + today_m + '\'' +
                ", today_a='" + today_a + '\'' +
                ", today_n='" + today_n + '\'' +
                ", tom_m='" + tom_m + '\'' +
                ", tom_a='" + tom_a + '\'' +
                ", tom_n='" + tom_n + '\'' +
                '}';
    }
}
