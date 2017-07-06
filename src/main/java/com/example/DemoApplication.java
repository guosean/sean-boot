package com.example;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.qunar.redis.storage.Sedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    private Sedis sedis = new Sedis("wap_mpush_test","be1e8df1");

    static Cache<String,String> cache = CacheBuilder.newBuilder().initialCapacity(10000).build();
    static final String gid = "7C74B32C-34C4-2C35-0DC0-C252E24D10F5";
    static{
        for(int i=0; i<10000; i++){
            cache.put(gid+i,String.valueOf(i));
        }
    }

    @RequestMapping("/")
    String home(){
        String str = ",boot";

        String result =  "test world" + str;
        return result;
    }

    @RequestMapping("/name")
    String name(){
        return "name";
    }

    @RequestMapping("/cache")
    String getCache(){
//        return sedis.get("7C74B32C-34C4-2C35-0DC0-C252E24D10F5");
        return cache.getIfPresent(gid+"1");
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
