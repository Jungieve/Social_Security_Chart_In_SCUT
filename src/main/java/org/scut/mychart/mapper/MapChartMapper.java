package org.scut.mychart.mapper;

import org.scut.mychart.model.MapChartModel;

import java.util.List;
import java.util.Map;

/**
 * @author gzw
 * 数据地图mapper
 */
public interface MapChartMapper {
	List<MapChartModel> selectMapChartPayment(Map<String, String> param);
	List<MapChartModel> selectMapChartCharges(Map<String, String> param);
}	

