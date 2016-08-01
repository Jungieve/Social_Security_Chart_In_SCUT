package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.FunnelRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class FunnelRedisDaoImpl extends RedisBase implements FunnelRedisDao {
	
	private static final Logger log = Logger.getLogger(FunnelRedisDaoImpl.class);

	@Override
	public String getFunnelData(String type) {
		Jedis jedis = null;
		String data = "";
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("FunnelRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		return data;
	}

	@Override
	public void setFunnelData(String type, String data) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
	}
	
}
