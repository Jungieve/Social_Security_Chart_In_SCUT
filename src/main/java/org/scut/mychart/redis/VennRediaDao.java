package org.scut.mychart.redis;

/**
 * Created by linqidi on 2016/8/1.
 */
public interface VennRediaDao {
    public String getVennData(String type);

    public void setVennData(String type, String data);
}
