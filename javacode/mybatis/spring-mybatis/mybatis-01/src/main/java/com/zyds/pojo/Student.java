package com.zyds.pojo;

import java.util.*;

public class Student {
    private String name;
    private ByeBye bye;
    private int[] number;
    private List<String> books;
    private Map<String,Integer> code;
    private Set<String> games;
    private String string;
    private Properties prop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ByeBye getBye() {
        return bye;
    }

    public void setBye(ByeBye bye) {
        this.bye = bye;
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Map<String, Integer> getCode() {
        return code;
    }

    public void setCode(Map<String, Integer> code) {
        this.code = code;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", bye=" + bye +
                ", number=" + Arrays.toString(number) +
                ", books=" + books +
                ", code=" + code +
                ", games=" + games +
                ", string='" + string + '\'' +
                ", prop=" + prop +
                '}';
    }
}
