package org.scut.mychart.redis;

public interface MapRedisDao {
	public String getMapData(String type);
	
	public void setMapData(String type, String data);
}
