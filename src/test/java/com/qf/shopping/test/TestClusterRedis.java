package com.qf.shopping.test;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.qf.shopping.pojo.AdvertismentExample;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class TestClusterRedis {

//	@SuppressWarnings("resource")
	@Test
	public void test() throws IOException{
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/bean-redis.xml");
//		RedisTemplate rt = context.getBean(RedisTemplate.class);
//		rt.opsForHash().put("zz", "kk", "dd");
//		rt.opsForHash().get("zz", "kk");
//		Jedis jedis = new Jedis("120.79.233.168",6379);
//		jedis.append("kk", "mvp");
		//连接集群
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("120.79.233.168", 5001));
		nodes.add(new HostAndPort("120.79.233.168", 5002));
		nodes.add(new HostAndPort("120.79.233.168", 5003));
		nodes.add(new HostAndPort("120.79.233.168", 5004));
		nodes.add(new HostAndPort("120.79.233.168", 5005));
		nodes.add(new HostAndPort("120.79.233.168", 5006));
		JedisCluster cluster = new JedisCluster(nodes);
		//操作集群
		String result1 = cluster.get("oo");
		cluster.set("oo", "gggg");
		String result2 = cluster.get("oo");
		System.out.println("修改前："+result1+"----"+"修改后："+result2);
		cluster.close();
		
	}
}
