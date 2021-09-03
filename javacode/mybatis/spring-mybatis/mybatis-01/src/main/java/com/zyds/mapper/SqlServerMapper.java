package com.zyds.mapper;

public class SqlServerMapper implements Mapper{
    @Override
    public void getSql() {
        System.out.println("SqlServer被链接");
    }
}
