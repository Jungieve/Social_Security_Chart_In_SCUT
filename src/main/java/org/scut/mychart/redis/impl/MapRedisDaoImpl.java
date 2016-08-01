package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.MapRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class MapRedisDaoImpl extends RedisBase implements MapRedisDao {

	private static final Logger log = Logger.getLogger(MapRedisDaoImpl.class);
	
	@Override
	public String getMapData(String type) {
		Jedis jedis = null;
		String data = "";
		
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("MapRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return data;
	}

	@Override
	public void setMapData(String type, String data) {
		Jedis jedis = null;
		
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			log.error("MapRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
	}

}
