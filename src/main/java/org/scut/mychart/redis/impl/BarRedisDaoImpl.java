package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.BarRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;


@Service
public class BarRedisDaoImpl extends RedisBase implements BarRedisDao {
	
	private static final Logger log = Logger.getLogger(BarRedisDaoImpl.class);

	@Override
	public String getBarData(String type) {
		Jedis jedis = null;
		String data = "";
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("BarRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return data;
	}

	@Override
	public void setBarData(String type, String data) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			log.error("BarRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
	}

}
