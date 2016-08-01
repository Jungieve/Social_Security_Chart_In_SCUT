package org.scut.mychart.redis;

public interface FunnelRedisDao {
	public String getFunnelData(String type);
	
	public void setFunnelData(String type, String data);
}
