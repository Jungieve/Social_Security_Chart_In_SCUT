package org.scut.mychart.service;

import java.util.Map;

public interface GaugeChartService {
	/**
	 * 用于获取失业保险仪表盘
	 * @return
	 */
	public Map<String, Object> getOutworkData();
	
	/**
	 * 用于获取养老保险仪表盘
	 * @return
	 */
	public Map<String, Object> getOldData();
	
	/**
	 * 用于获取医疗保险仪表盘
	 * @return
	 */
	public Map<String, Object> getMedicineData();
	
	/**
	 * 用于获取生育保险仪表盘
	 * @return
	 */
	public Map<String, Object> getBirthData();
	
	/**
	 * 用于获取工伤保险仪表盘
	 * @return
	 */
	public Map<String, Object> getInjuryData();
}
