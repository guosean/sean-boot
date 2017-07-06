package com.example.aop.service;

import com.example.annotations.Monitor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by guozhenbin on 2017/1/24.
 */
@Component
public class HelloService {

    private String name;

    @Cacheable(value = "guavaDemo",key = "#name")
    @Monitor(value = "getHelloMsg")
    public String getHelloMsg(final String name){
        System.out.println("helloword ");
        return "hello,sean";
    }

}
