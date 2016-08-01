package org.scut.mychart.redis;

public interface WordcloudRedisDao {
	public String getWordcloudData(String type);
	
	public void setWordcloudData(String type, String data);
}
