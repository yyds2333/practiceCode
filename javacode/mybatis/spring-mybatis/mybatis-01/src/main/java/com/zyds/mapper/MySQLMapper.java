package com.zyds.mapper;

public class MySQLMapper implements Mapper{
    @Override
    public void getSql() {
        System.out.println("MySQL被链接");
    }
}
