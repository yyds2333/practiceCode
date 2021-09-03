package com.uuyd.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {

//    @Value("汪汪")
    private String wow;

    public Dog() {
    }

    public Dog(String wow) {
        this.wow = wow;
    }

    public String getWow() {
        return wow;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "wow='" + wow + '\'' +
                '}';
    }
}
