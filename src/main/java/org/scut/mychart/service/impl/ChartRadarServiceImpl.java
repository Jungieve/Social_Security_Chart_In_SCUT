package org.scut.mychart.service.impl;

import com.github.abel533.echarts.Data;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.data.SeriesData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.*;
import com.github.abel533.echarts.*;

import com.github.abel533.echarts.style.LineStyle;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import org.scut.mychart.redis.RadarRedisDao;
import org.scut.mychart.mapper.ChartRadarMapper;
import org.scut.mychart.mapper.ChartsMapper;
import org.scut.mychart.model.*;
import org.scut.mychart.service.ChartRadarService;
import org.scut.mychart.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ChartRadarServiceImpl implements ChartRadarService {
	@Resource
	private ChartRadarMapper chartsDao;

	@Autowired
	private RadarRedisDao radarRedisDao;

	public List<ChartRadar> getChartRadarData(){
		return this.chartsDao.selectChartRadar();
	}

	public Integer getTypeint(String type) {
		//0养老，1医疗，2失业，3工伤，4生育
		if (type.equals("养老保险")) return 0;
		else if (type.equals("医疗保险")) return 1;
		else if (type.equals("失业保险")) return 2;
		else if (type.equals("工伤保险")) return 3;
		else if (type.equals("生育保险")) return 4;
		else return 5;
	}

	public String getChartRadarOption() {

		String type = ChartTypeConstant.Radar_REDIS;

		String RadarData = radarRedisDao.getRadarData(type);

		if(RadarData != null && !RadarData.isEmpty()) {
			return RadarData;
		}

		GsonOption option = new GsonOption();
		List<ChartRadar> list = getChartRadarData();

		option.title("五险参保人数雷达图");
		//option.title().x(X.right);option.title().y(Y.bottom);
		//option.color("(function (){var zrColor = require('zrender/tool/color');return zrColor.getStepColors('yellow', 'red', 28);})()");
		option.tooltip(Trigger.item);
		option.tooltip().backgroundColor("rgba(0,0,250,0.2)");
		option.toolbox().show(true);
		option.toolbox().orient(Orient.vertical);
		option.toolbox().y(Y.center);
		option.toolbox().feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
		option.calculable(false);
		Radar radar = new Radar();
		Integer yyyy = 0;
		List<Integer> maxx = new ArrayList<Integer>(),minn = new ArrayList<Integer>();
		maxx.add(-1);maxx.add(-1);maxx.add(-1);maxx.add(-1);maxx.add(-1);
		minn.add(Integer.MAX_VALUE);minn.add(Integer.MAX_VALUE);minn.add(Integer.MAX_VALUE);minn.add(Integer.MAX_VALUE);minn.add(Integer.MAX_VALUE);
		List<String> legData = new ArrayList<String>();

		HashMap<String, Object> rData = new HashMap<String, Object>();
		List<Integer> value = new ArrayList<Integer>();
		for (ChartRadar chart:list)
		{
			if (chart.getyear().intValue() != yyyy) {
				radar.name("参保人数").symbol(Symbol.none).itemStyle().normal().lineStyle().width(1);
				radar.itemStyle().emphasis().areaStyle().color("rgba(0,250,0,0.3)");
				if (yyyy != 0){
					rData.put("value",value);rData.put("name",Integer.toString(yyyy));
					radar.data(rData);
					option.series(radar);
					radar = new Radar();
					rData = new HashMap<String, Object>();
					value = new ArrayList<Integer>();
				}
				int typei = getTypeint(chart.getType());
				if (chart.getperson_num().intValue() > maxx.get(typei)) maxx.set(typei, chart.getperson_num().intValue());
				if (chart.getperson_num().intValue() < minn.get(typei)) minn.set(typei, chart.getperson_num().intValue());
				value.add(chart.getperson_num().intValue());
				yyyy=chart.getyear();
				legData.add(Integer.toString(yyyy));
			}
			else {
				int typei = getTypeint(chart.getType());
				if (chart.getperson_num().intValue() > maxx.get(typei)) maxx.set(typei, chart.getperson_num().intValue());
				if (chart.getperson_num().intValue() < minn.get(typei)) minn.set(typei, chart.getperson_num().intValue());
				value.add(chart.getperson_num().intValue());
			}
		}
		radar.name("参保人数").symbol(Symbol.none).itemStyle().normal().lineStyle().width(1);
		radar.itemStyle().emphasis().areaStyle().color("rgba(0,250,0,0.3)");
		rData.put("value",value);rData.put("name",Integer.toString(yyyy));
		radar.data(rData);
		option.series(radar);
		option.legend().data(legData);
		Polar polar = new Polar();
		HashMap<String, Object> tem = new HashMap<String, Object>();
		tem.put("text","养老保险");tem.put("max",(int)(maxx.get(0)*1.01));tem.put("min",(int)(minn.get(0)*0.99));
		polar.indicator(tem);tem = new HashMap<String, Object>();
		tem.put("text","医疗保险");tem.put("max",(int)(maxx.get(1)*1.01));tem.put("min",(int)(minn.get(1)*0.99));
		polar.indicator(tem);tem = new HashMap<String, Object>();
		tem.put("text","失业保险");tem.put("max",(int)(maxx.get(2)*1.01));tem.put("min",(int)(minn.get(2)*0.99));
		polar.indicator(tem);tem = new HashMap<String, Object>();
		tem.put("text","工伤保险");tem.put("max",(int)(maxx.get(3)*1.01));tem.put("min",(int)(minn.get(3)*0.99));
		polar.indicator(tem);tem = new HashMap<String, Object>();
		tem.put("text","生育保险");tem.put("max",(int)(maxx.get(4)*1.01));tem.put("min",(int)(minn.get(4)*0.99));
		polar.indicator(tem);
		polar.center("50%", 240);
		polar.radius(150);
		option.polar(polar);

		radarRedisDao.setRadarData(type, option.toString());

		return option.toString();
	}

}

