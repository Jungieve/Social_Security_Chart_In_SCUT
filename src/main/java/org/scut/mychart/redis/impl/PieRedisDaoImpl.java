package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.PieRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class PieRedisDaoImpl extends RedisBase implements PieRedisDao {
	
	private static final Logger log = Logger.getLogger(PieRedisDaoImpl.class);

	@Override
	public String getPieData(String type) {
		Jedis jedis = null;
		String data = "";
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("PieRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return data;
	}

	@Override
	public void setPieData(String type, String data) {
		Jedis jedis = null;
		
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			log.error("PieRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
	}

}
