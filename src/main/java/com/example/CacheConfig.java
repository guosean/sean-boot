package com.example;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by guozhenbin on 2017/7/7.
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(){
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager("guavaDemo");
        CacheBuilder<Object,Object> cacheBuilder = CacheBuilder.newBuilder();
        cacheBuilder.expireAfterWrite(10, TimeUnit.SECONDS);
        guavaCacheManager.setCacheBuilder(cacheBuilder);

        return guavaCacheManager;
    }

}
