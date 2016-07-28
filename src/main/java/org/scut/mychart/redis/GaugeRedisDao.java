package org.scut.mychart.redis;

import java.util.List;

import org.scut.mychart.model.GaugeChartModel;

public interface GaugeRedisDao {
	public void setGaugeData(String name);
	
	public List<GaugeChartModel> getGaugeDataByType(String type);
	
	public void setGaugeDataByType(String type, List<GaugeChartModel> data);
}
