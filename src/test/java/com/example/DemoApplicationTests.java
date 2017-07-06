package com.example;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.qunar.redis.storage.Sedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private EmbeddedServletContainerFactory containerFactory;

	static Cache cache = CacheBuilder.newBuilder().initialCapacity(10000).build();
	static final String gid = "7C74B32C-34C4-2C35-0DC0-C252E24D10F5";
	static{
		for(int i=0; i<10000; i++){
			cache.put(gid+i,i);
		}
	}


	@Test
	public void testLoad(){
		System.out.println(containerFactory);
	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedis(){
		Sedis sedis = new Sedis("wap_mpush_test","be1e8df1");
		System.out.println(sedis.get("test"));
	}
}
