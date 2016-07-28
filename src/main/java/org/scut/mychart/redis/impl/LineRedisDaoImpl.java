package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.LineRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class LineRedisDaoImpl extends RedisBase implements LineRedisDao {

	private static final Logger log = Logger.getLogger(LineRedisDaoImpl.class);
	
	@Override
	public String getLineData(String type) {
		Jedis jedis = null;
		String data = "";
		
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("LineRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return data;
	}

	@Override
	public void setLineData(String type, String data) {
		Jedis jedis = null;
		
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			log.error("LineRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
	}

}
