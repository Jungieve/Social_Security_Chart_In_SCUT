package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.WordcloudRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service
public class WordcloudDaoImpl extends RedisBase implements WordcloudRedisDao {
	
	private static final Logger log = Logger.getLogger(WordcloudDaoImpl.class);

	@Override
	public String getWordcloudData(String type) {
		Jedis jedis = null;
		String data = "";
		try {
			jedis = getJedis();
			data = jedis.get(type);
		} catch (Exception e) {
			log.error("WordcloudRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return data;
	}

	@Override
	public void setWordcloudData(String type, String data) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(type, data);
		} catch (Exception e) {
			log.error("WordcloudRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
	}

}
