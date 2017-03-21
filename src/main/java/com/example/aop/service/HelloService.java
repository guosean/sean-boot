package com.example.aop.service;

import org.springframework.stereotype.Component;

/**
 * Created by guozhenbin on 2017/1/24.
 */
@Component
public class HelloService {

    private String name;

    public String getHelloMsg(){
        return "hello,sean";
    }

}
