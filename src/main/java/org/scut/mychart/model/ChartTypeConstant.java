package org.scut.mychart.model;

public interface ChartTypeConstant {
	
	//总人数
	public static final int TOTAL_PEOPLE = 140000;
	
	//仪表盘
	public static final String GAUGE = "gauge";
	
	/**
	 * 下面是用于设置redis的key
	 */
	//失业仪表盘
	public static final String OUTWORK_GAUGE_REDIS = "OUTWORK_GAUGE_REDIS";
	
	//养老仪表盘
	public static final String OLD_GAUGE_REDIS = "OLD_GAUGE_REDIS";
	
	//医疗仪表盘
	public static final String MEDICINE_GAUGE_REDIS = "MEDICINE_GAUGE_REDIS";
	
	//工伤仪表盘
	public static final String INJURY_GAUGE_REDIS = "INJURY_GAUGE_REDIS";
	
	//生育仪表盘
	public static final String BIRTH_GAUGE_REDIS = "BIRTH_GAUGE_REDIS";
	
	//养老柱状图
	public static final String ENDOWMENT_BAR_REDIS = "ENDOWMENT_BAR_REDIS";
	
	//失业柱状图
	public static final String UNEMPLOYMENT_BAR_REDIS = "UNEMPLOYMENT_BAR_REDIS";
	
	//医疗柱状图
	public static final String MEDICAL_BAR_REDIS = "MEDICAL_BAR_REDIS";
	
	//工伤柱状图
	public static final String INJURY_BAR_REDIS = "INJURY_BAR_REDIS";
	
	//生育柱状图
	public static final String BIRTH_BAR_REDIS = "BIRTH_BAR_REDIS";

	//养老折线图
	public static final String ENDOWMENT_LINE_REDIS = "ENDOWMENT_LINE_REDIS";
	
	//失业折线图
	public static final String UNEMPLOYMENT_LINE_REDIS = "UNEMPLOYMENT_LINE_REDIS";
	
	//医疗折线图
	public static final String MEDICAL_LINE_REDIS = "MEDICAL_LINE_REDIS";
	
	//工伤折线图
	public static final String INJURY_LINE_REDIS = "INJURY_LINE_REDIS";
	
	//生育折线图
	public static final String BIRTH_LINE_REDIS = "BIRTH_LINE_REDIS";
	
	//综合分析饼图
	public static final String ANALYSIS_PIE_REDIS = "ANALYSIS_PIE_REDIS";

	//雷达图
	public static final String Radar_REDIS = "Radar_REDIS";
	
	//漏斗图
	public static final String FUNNEL_REDIS = "FUNNEL_REDIS";
	
	//失业支付漏斗图
	public static final String UNEMPLOYMENT_FUNNEL_PAY_REDIS = "UNEMPLOYMENT_FUNNEL_PAY_REDIS";
	
	//养老支付漏斗图
	public static final String ENDOWMENT_FUNNEL_PAY_REDIS = "ENDOWMENT_FUNNEL_PAY_REDIS";
	
	//医疗支付漏斗图
	public static final String MEDICAL_FUNNEL_PAY_REDIS = "MEDICAL_FUNNEL_PAY_REDIS";
	
	//生育支付漏斗图
	public static final String BIRTH_FUNNEL_PAY_REDIS = "BIRTH_FUNNEL_PAY_REDIS";
	
	//工伤支付漏斗图
	public static final String INJURY_FUNNEL_PAY_REDIS = "INJURY_FUNNEL_PAY_REDIS";
}
