package com.qf.shopping.manager;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Component
public class CacheManager {

	private JedisCluster getCluster() {
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("120.79.233.168", 5001));
		nodes.add(new HostAndPort("120.79.233.168", 5002));
		nodes.add(new HostAndPort("120.79.233.168", 5003));
		nodes.add(new HostAndPort("120.79.233.168", 5004));
		nodes.add(new HostAndPort("120.79.233.168", 5005));
		nodes.add(new HostAndPort("120.79.233.168", 5006));
		JedisCluster cluster = new JedisCluster(nodes);
		return cluster;
	}
	/**使用redis-bean来操作
	public void getTemplate(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classPath:bean-redis.xml");
		RedisTemplate redisTemplate = ac.getBean(RedisTemplate.class);
	}*/
	
	// 将广告放入Redis
	public void putAd(String ads) {
		JedisCluster cluster = getCluster();
		// 操作集群
		cluster.hset("ads", "recycleAd", ads);
	}

	// 取出广告
	public String getAd() throws IOException {
		JedisCluster cluster = getCluster();
		String hget = cluster.hget("ads", "recycleAd");
		return hget;
	}
	
	// 将分类数据 放入Redis
	public void putFirstType(String firsts) {
		JedisCluster cluster = getCluster();
		// 操作集群
		cluster.hset("firstType", "first", firsts);
	}

	// 取出分类数据
	public String getFirstType() {
		JedisCluster cluster = getCluster();
		String string = cluster.hget("firstType", "first");
		System.out.println(string);
		return string;
	}

	// 将最新最热的商品 放入redis

 
	//将购物车的信息放到redis里面
	public void putShopCar(String shopCar,Integer goodId){
		JedisCluster cluster = getCluster();
		String goodIdString = goodId.toString();
		cluster.hset("shopCar",goodIdString, shopCar);
	} 
	
	//将购物车的信息全部取出来
	public Map<String, String> getAllShopCar(){
		JedisCluster cluster = getCluster();
		return cluster.hgetAll("shopCar");
	}
	
	//从购物车中取出指定商品
		public String getTheShopCar(Integer goodId){
			JedisCluster cluster = getCluster();
			String goodIdString = goodId.toString();
			return cluster.hget("shopCar", goodIdString);
		}
		
	//从购物车删除指定商品
		public void delete(Integer goodId){
			JedisCluster cluster = getCluster();
			String goodIdString = goodId.toString();
			cluster.hdel("shopCar", goodIdString);
			
		}
}
