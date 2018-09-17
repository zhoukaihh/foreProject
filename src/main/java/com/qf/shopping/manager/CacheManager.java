package com.qf.shopping.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	// 将广告放入Redis
	public void putAd(String ads) {
		JedisCluster cluster = getCluster();
		// 操作集群
		cluster.hset("ads", "recycleAd", ads);
	}

	// 取出广告
	public String getAd() {
		JedisCluster cluster = getCluster();
		return cluster.hget("ads", "recycleAd");
	}

	// 将分类数据 放入Redis
	public void putFirstType(String firsts) {
		JedisCluster cluster = getCluster();
		// 操作集群
		cluster.hset("first", "firstType", firsts);
	}

	// 取出分类数据
	public String getFirstType() {
		JedisCluster cluster = getCluster();
		return cluster.hget("first", "firstType");
	}

	// 将最新最热的商品 放入redis

}
