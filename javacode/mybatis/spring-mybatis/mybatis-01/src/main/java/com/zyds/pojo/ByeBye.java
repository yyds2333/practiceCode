package com.zyds.pojo;

public class ByeBye {
    private String bye;

    public ByeBye(String bye) {
        this.bye = bye;
        System.out.println("Bye-----Bye");
    }

    public String getBye() {
        return bye;
    }

    public void setBye(String bye) {
        this.bye = bye;
    }

    @Override
    public String toString() {
        return "ByeBye{" +
                "bye='" + bye + '\'' +
                '}';
    }
}
