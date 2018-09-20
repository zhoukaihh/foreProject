package com.qf.shopping.manager;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterManager {
	
	public static void get(){
		ThreadLocal<JedisCluster> t = new ThreadLocal<JedisCluster> ();
		
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("120.79.233.168", 5001));
		nodes.add(new HostAndPort("120.79.233.168", 5002));
		nodes.add(new HostAndPort("120.79.233.168", 5003));
		nodes.add(new HostAndPort("120.79.233.168", 5004));
		nodes.add(new HostAndPort("120.79.233.168", 5005));
		nodes.add(new HostAndPort("120.79.233.168", 5006));
		JedisCluster cluster = new JedisCluster(nodes);
		
		t.set(cluster);
	}
	
	public static void main(String[] args) {
		
	}
	
}
