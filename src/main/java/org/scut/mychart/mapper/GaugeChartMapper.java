package org.scut.mychart.mapper;

import java.util.List;

import org.scut.mychart.model.GaugeChartModel;

public interface GaugeChartMapper {
	public List<GaugeChartModel> getChartTotalByYear();
}
