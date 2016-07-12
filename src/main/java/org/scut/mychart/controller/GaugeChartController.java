package org.scut.mychart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scut.mychart.mapper.GaugeChartMapper;
import org.scut.mychart.model.GaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.echarts.json.GsonOption;

@Controller
@RequestMapping(value="/charts", produces="application/json;charset=UTF-8")
public class GaugeChartController {
	@Autowired
	private GaugeChartMapper gaugeChartMapper;
	
	@RequestMapping("/chart07")
    @ResponseBody
    public Map toIndex(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<GaugeChartModel> chartData = gaugeChartMapper.getChartTotalByYear();
		map.put("test", chartData);
        return map;
    }  
}
