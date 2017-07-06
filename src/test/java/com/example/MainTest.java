package com.example;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

/**
 * Created by guozhenbin on 2017/7/6.
 */

public class MainTest {

    @Test
    public void testCache(){
        CacheBuilder cacheBuilder = CacheBuilder.newBuilder().initialCapacity(10000);
        Cache cache = cacheBuilder.build();
        for(int i=0; i<10000; i++){
            cache.put("7C74B32C-34C4-2C35-0DC0-C252E24D10F5"+i,i);
        }

        System.out.println(cache.getIfPresent("7C74B32C-34C4-2C35-0DC0-C252E24D10F510"));
    }

}
