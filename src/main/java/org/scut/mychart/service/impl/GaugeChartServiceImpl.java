package org.scut.mychart.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scut.mychart.controller.Chart01Controller;
import org.scut.mychart.mapper.GaugeChartMapper;
import org.scut.mychart.model.ChartTypeConstant;
import org.scut.mychart.model.GaugeChartModel;
import org.scut.mychart.redis.GaugeRedisDao;
import org.scut.mychart.service.GaugeChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.json.GsonOption;

@Service
public class GaugeChartServiceImpl implements GaugeChartService {
	
	@Autowired
	private GaugeChartMapper gaugeChartMapper;
	
	@Autowired
	private GaugeRedisDao gaugeRedisDao;

	public Map<String, Object> getOutworkData() {
		Map<String, Object> data = new HashMap<String, Object>();
//		List<GaugeChartModel> list = gaugeChartMapper.getOutworkCoverageTotalByYear();
		
		List<GaugeChartModel> list = gaugeRedisDao.getGaugeDataByType(ChartTypeConstant.OUTWORK_GAUGE_REDIS);

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	public Map<String, Object> getOldData() {
		Map<String, Object> data = new HashMap<String, Object>();
//		List<GaugeChartModel> list = gaugeChartMapper.getOldCoverageTotalByYear();
		
		List<GaugeChartModel> list = gaugeRedisDao.getGaugeDataByType(ChartTypeConstant.OLD_GAUGE_REDIS);

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	public Map<String, Object> getMedicineData() {
		Map<String, Object> data = new HashMap<String, Object>();
//		List<GaugeChartModel> list = gaugeChartMapper.getMedicineCoverageTotalByYear();

		List<GaugeChartModel> list = gaugeRedisDao.getGaugeDataByType(ChartTypeConstant.MEDICINE_GAUGE_REDIS);
		
		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	public Map<String, Object> getBirthData() {
		Map<String, Object> data = new HashMap<String, Object>();
//		List<GaugeChartModel> list = gaugeChartMapper.getBirthCoverageTotalByYear();

		List<GaugeChartModel> list = gaugeRedisDao.getGaugeDataByType(ChartTypeConstant.BIRTH_GAUGE_REDIS);
		
		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	public Map<String, Object> getInjuryData() {
		Map<String, Object> data = new HashMap<String, Object>();
//		List<GaugeChartModel> list = gaugeChartMapper.getInjuryCoverageTotalByYear();
		
		List<GaugeChartModel> list = gaugeRedisDao.getGaugeDataByType(ChartTypeConstant.INJURY_GAUGE_REDIS);

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}


}
