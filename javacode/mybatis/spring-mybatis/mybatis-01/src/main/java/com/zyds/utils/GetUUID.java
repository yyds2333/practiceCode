package com.zyds.utils;

import org.junit.Test;

import java.util.UUID;

public class GetUUID {
    public static String getUUID(){
        String uuid= java.util.UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
    @Test
    public void test(){
        System.out.println(getUUID());
        System.out.println(getUUID());
        System.out.println(getUUID());
    }
}

