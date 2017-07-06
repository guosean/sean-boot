package com.example.controller;

import com.example.aop.service.HelloService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by guozhenbin on 2017/7/6.
 */
@RestController
public class BootController {
//    private Sedis sedis = new Sedis("wap_mpush_test","be1e8df1");

    static Cache<String,String> cache = CacheBuilder.newBuilder().initialCapacity(10000).build();
    static final String gid = "7C74B32C-34C4-2C35-0DC0-C252E24D10F5";
    static{
        for(int i=0; i<10000; i++){
            cache.put(gid+i,String.valueOf(i));
        }
    }

    @Resource
    private HelloService helloService;

    @RequestMapping("/")
    String home(){
        String str = ",boot";

        String result =  "test world" + str;
        return result;
    }

    @RequestMapping("/hello")
    String name(){
        return helloService.getHelloMsg("test");
    }

    @RequestMapping("/cache")
    String getCache(){
//        return sedis.get("7C74B32C-34C4-2C35-0DC0-C252E24D10F5");
        return cache.getIfPresent(gid+"1");
    }
}
