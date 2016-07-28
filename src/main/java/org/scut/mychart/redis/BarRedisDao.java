package org.scut.mychart.redis;

public interface BarRedisDao {
	public String getBarData(String type);
	
	public void setBarData(String type, String data);
}
