package org.scut.mychart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scut.mychart.mapper.GaugeChartMapper;
import org.scut.mychart.model.ChartTypeConstant;
import org.scut.mychart.model.GaugeChartModel;
import org.scut.mychart.redis.GaugeRedisDao;
import org.scut.mychart.service.GaugeChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.echarts.json.GsonOption;

@Controller
@RequestMapping(value="/charts", produces="application/json;charset=UTF-8")
public class GaugeChartController {
	@Autowired
	private GaugeChartService gaugeChartService;
	
	@Autowired
	private GaugeRedisDao gaugeRedisDao;
	
	@RequestMapping("/outworkGauge")
    @ResponseBody
    public Map<String, Object> toIndex(){
		Map<String, Object> map =  gaugeChartService.getOutworkData();
        return map;
    }  
	
	@RequestMapping("/oldGauge")
	@ResponseBody
	public Map<String, Object> oldGauge(){
		Map<String, Object> map =  gaugeChartService.getOldData();
		return map;
	}  
	
	@RequestMapping("/medicineGauge")
	@ResponseBody
	public Map<String, Object> medicineGauge(){
		Map<String, Object> map =  gaugeChartService.getMedicineData();
		return map;
	}  
	
	@RequestMapping("/birthGauge")
	@ResponseBody
	public Map<String, Object> birthGauge(){
		Map<String, Object> map =  gaugeChartService.getBirthData();
		return map;
	}  
	
	@RequestMapping("/injuryGauge")
	@ResponseBody
	public Map<String, Object> injuryGauge(){
		Map<String, Object> map =  gaugeChartService.getInjuryData();
		return map;
	}
	
	@RequestMapping("/testRedis")
	@ResponseBody
	public void testRedis(){
		gaugeRedisDao.setGaugeData("Guia");
	}  
}
