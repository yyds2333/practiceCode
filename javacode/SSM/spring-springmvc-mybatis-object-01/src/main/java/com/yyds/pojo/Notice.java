package com.yyds.pojo;

public class Notice {
    private int id;
    private String notice;

    public Notice() {
    }

    public Notice(int id, String notice) {
        this.id = id;
        this.notice = notice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", notice='" + notice + '\'' +
                '}';
    }
}
