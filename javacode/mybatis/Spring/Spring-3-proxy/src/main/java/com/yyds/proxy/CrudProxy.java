package com.yyds.proxy;

import com.yyds.pojo.Crud;
import com.yyds.pojo.CrudImpl;

public class CrudProxy implements Crud {
    Crud crud;

    public void setCrud(Crud crud) {
        this.crud = crud;
    }

    @Override
    public void add() {
        crud.add();
        sout();
    }

    @Override
    public void delete() {
        crud.delete();
        sout();
    }

    @Override
    public void update() {
        crud.update();
        sout();
    }

    @Override
    public void query() {
        crud.query();
        sout();
    }

    public void sout(){
        System.out.println("代理类查询");
    }
}
