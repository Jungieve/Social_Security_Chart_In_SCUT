package org.scut.mychart.redis;

public interface PieRedisDao {
	public String getPieData(String type);
	
	public void setPieData(String type, String data);
}
