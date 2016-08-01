package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.RadarRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service
public class RadarRedisDaoImpl extends RedisBase implements RadarRedisDao {
	
	private static final Logger log = Logger.getLogger(RadarRedisDaoImpl.class);

	@Override
	public String getRadarData(String type) {
		Jedis jedis = null;
		String data = "";
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("RadarRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return data;
	}

	@Override
	public void setRadarData(String type, String data) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			log.error("RadarRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
	}

}
