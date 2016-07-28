package org.scut.mychart.redis;

public interface LineRedisDao {
	public String getLineData(String type);
	
	public void setLineData(String type, String data);
}
