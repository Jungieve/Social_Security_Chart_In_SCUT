package org.scut.mychart.redis.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.scut.mychart.mapper.GaugeChartMapper;
import org.scut.mychart.model.ChartTypeConstant;
import org.scut.mychart.model.GaugeChartModel;
import org.scut.mychart.redis.GaugeRedisDao;
import org.scut.mychart.redis.RedisBase;
import org.scut.mychart.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;

@Service
public class GaugeRedisDaoImpl extends RedisBase implements GaugeRedisDao {

	private static final Logger log = Logger.getLogger(GaugeRedisDaoImpl.class);
	
	@Autowired
	private GaugeChartMapper gaugeChartMapper;
	
	public void setGaugeData(String name) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set("test", name);
		} catch (Exception e) {
			log.error(e);
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
	}

	@Override
	public List<GaugeChartModel> getGaugeDataByType(String type) {
		Jedis jedis = null;
		List<GaugeChartModel> list = null;
		try {
			jedis = getJedis();
			String data = jedis.get(type);
			if(data == null || data.isEmpty()) {
				if(type.equals(ChartTypeConstant.OUTWORK_GAUGE_REDIS)) {
					list = gaugeChartMapper.getOutworkCoverageTotalByYear();
				}else if(type.equals(ChartTypeConstant.BIRTH_GAUGE_REDIS)) {
					list = gaugeChartMapper.getBirthCoverageTotalByYear();
				}else if(type.equals(ChartTypeConstant.OLD_GAUGE_REDIS)) {
					list = gaugeChartMapper.getOldCoverageTotalByYear();
				}else if(type.equals(ChartTypeConstant.MEDICINE_GAUGE_REDIS)) {
					list = gaugeChartMapper.getMedicineCoverageTotalByYear();
				}else if(type.equals(ChartTypeConstant.INJURY_GAUGE_REDIS)) {
					list = gaugeChartMapper.getInjuryCoverageTotalByYear();
				}
				//设置redis缓存
				setGaugeDataByType(type, list);
			}else {
				list = JSONUtils.fromJson(data, new TypeToken<List<GaugeChartModel>>(){});
			}
		} catch (Exception e) {
			log.error("GaugeRedisDaoImpl get data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
		
		return list;
	}

	@Override
	public void setGaugeDataByType(String type, List<GaugeChartModel> data) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(type, JSONUtils.toJson(data, false));
		} catch (Exception e) {
			log.error("GaugeRedisDaoImpl set data error: " + e.getMessage());
			returnBrokenResource(jedis);
		} finally {
			returnResource(jedis);
		}
	}

}
