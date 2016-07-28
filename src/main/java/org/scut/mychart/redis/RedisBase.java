package org.scut.mychart.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisBase {
	
	private static final Logger log = Logger.getLogger(RedisBase.class);
	
	@Autowired
	private JedisPool jedisPool;
	
	public Jedis getJedis() {
		try {
			Jedis jedis = jedisPool.getResource();
			return jedis;
		} catch (Exception e) {
			log.error(e);
		}

		return null;
	}
	
	public void returnResource(Jedis jedis) {
		jedisPool.returnResource(jedis);
	}
	
	public void returnBrokenResource(Jedis jedis) {
		jedisPool.returnBrokenResource(jedis);
	}
}
