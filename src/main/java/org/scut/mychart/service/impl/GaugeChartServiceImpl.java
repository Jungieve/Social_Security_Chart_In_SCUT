package org.scut.mychart.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scut.mychart.controller.Chart01Controller;
import org.scut.mychart.mapper.GaugeChartMapper;
import org.scut.mychart.model.ChartTypeConstant;
import org.scut.mychart.model.GaugeChartModel;
import org.scut.mychart.service.GaugeChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.json.GsonOption;

@Service
public class GaugeChartServiceImpl implements GaugeChartService {
	
	@Autowired
	private GaugeChartMapper gaugeChartMapper;

	@Override
	public Map<String, Object> getOutworkData() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<GaugeChartModel> list = gaugeChartMapper.getOutworkCoverageTotalByYear();

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	@Override
	public Map<String, Object> getOldData() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<GaugeChartModel> list = gaugeChartMapper.getOldCoverageTotalByYear();

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	@Override
	public Map<String, Object> getMedicineData() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<GaugeChartModel> list = gaugeChartMapper.getMedicineCoverageTotalByYear();

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	@Override
	public Map<String, Object> getBirthData() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<GaugeChartModel> list = gaugeChartMapper.getBirthCoverageTotalByYear();

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}

	@Override
	public Map<String, Object> getInjuryData() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<GaugeChartModel> list = gaugeChartMapper.getInjuryCoverageTotalByYear();

		data.put("data", list);
		data.put("type", ChartTypeConstant.GAUGE);
		data.put("total", ChartTypeConstant.TOTAL_PEOPLE);
		
		return data;
	}


}
