package org.scut.mychart.redis;

public interface RadarRedisDao {
	public String getRadarData(String type);
	
	public void setRadarData(String type, String data);
}
