package com.yyds.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynmicProxy implements InvocationHandler {
    private Object target;


    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        Object obj= Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=method.invoke(target,args);
        return obj;
    }
}
