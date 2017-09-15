package com.example;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guozhenbin on 2017/7/6.
 */

public class MainTest {

    @Test
    public void test(){
        HashMap map = new HashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map);
    }

    @Test
    public void testCache(){
        CacheBuilder cacheBuilder = CacheBuilder.newBuilder().initialCapacity(10000);
        Cache cache = cacheBuilder.build();
        for(int i=0; i<10000; i++){
            cache.put("7C74B32C-34C4-2C35-0DC0-C252E24D10F5"+i,i);
        }

        System.out.println(cache.getIfPresent("7C74B32C-34C4-2C35-0DC0-C252E24D10F510"));
        Map<String,String> map = new HashMap();
        System.out.println(map.put("1","1"));
        System.out.println(map.put("1","2"));
        System.out.println(map.hashCode() % 3);
    }

}
