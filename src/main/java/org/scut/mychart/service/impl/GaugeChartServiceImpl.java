package org.scut.mychart.service.impl;

import java.util.List;

import org.scut.mychart.mapper.GaugeChartMapper;
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
	public GsonOption getGaugeChartOption() {
		GsonOption option = new GsonOption();
		
		/**
		 * 暂时获取jc14  失业支付的年份人数信息
		 */
		List<GaugeChartModel> chartData = gaugeChartMapper.getChartTotalByYear();
		
		option.tooltip().formatter("{a} <br/>{b} : {c}%");
		option.toolbox().show(false);
		
		return option;
	}

}
