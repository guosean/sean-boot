package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {


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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
