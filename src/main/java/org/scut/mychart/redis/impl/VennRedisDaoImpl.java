package org.scut.mychart.redis.impl;

import org.apache.log4j.Logger;
import org.scut.mychart.redis.RedisBase;
import org.scut.mychart.redis.VennRediaDao;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
/**
 * Created by linqidi on 2016/8/1.
 */
@Service
public class VennRedisDaoImpl extends RedisBase implements VennRediaDao {
    private static final Logger log = Logger.getLogger(VennRedisDaoImpl.class);
    @Override
    public String getVennData(String type) {
        Jedis jedis = null;
        String data = "";
        try {
            jedis = getJedis();
            data = jedis.get(type);
        } catch (Exception e) {
            log.error("VennRedisDaoImpl get data error: " + e.getMessage());
            returnBrokenResource(jedis);
        } finally {
            returnResource(jedis);
        }

        return data;
    }

    @Override
    public void setVennData(String type, String data) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(type, data);
        } catch (Exception e) {
            log.error("VennRedisDaoImpl set data error: " + e.getMessage());
            returnBrokenResource(jedis);
        } finally {
            returnResource(jedis);
        }

    }
}
