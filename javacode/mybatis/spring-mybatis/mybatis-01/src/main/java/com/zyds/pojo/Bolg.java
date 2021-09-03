package com.zyds.pojo;

import java.util.Date;

public class Bolg {
    private String id;
    private String blog;
    private Date creationDate;
    private int views;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Bolg{" +
                "id='" + id + '\'' +
                ", blog='" + blog + '\'' +
                ", creationDate=" + creationDate +
                ", views=" + views +
                '}';
    }
}
