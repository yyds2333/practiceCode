package com.zyds.mapper;

public class OracleMapper implements Mapper{
    @Override
    public void getSql() {
        System.out.println("Oracle被链接");
    }
}
