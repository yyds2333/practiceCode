package com.yyds.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

//@Alias("user")暂时用不了
@Data
public class User {
    private int id;
    private String name;
    private String userPassword;

}
