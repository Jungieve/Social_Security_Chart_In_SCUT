package org.scut.mychart.mapper;

import java.util.List;

import org.scut.mychart.model.GaugeChartModel;

public interface GaugeChartMapper {
	/**
	 * 用于失业保险的覆盖率
	 * @return
	 */
	public List<GaugeChartModel> getOutworkCoverageTotalByYear();
	
	/**
	 * 用于养老保险的覆盖率
	 * @return
	 */
	public List<GaugeChartModel> getOldCoverageTotalByYear();
	
	/**
	 * 用于医疗保险的覆盖率
	 * @return
	 */
	public List<GaugeChartModel> getMedicineCoverageTotalByYear();
	
	/**
	 * 用于生育保险的覆盖率
	 * @return
	 */
	public List<GaugeChartModel> getBirthCoverageTotalByYear();
	
	/**
	 * 用于工伤保险的覆盖率
	 * @return
	 */
	public List<GaugeChartModel> getInjuryCoverageTotalByYear();
}
