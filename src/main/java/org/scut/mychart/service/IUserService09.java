package org.scut.mychart.service;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.Chart09;

import java.util.List;

public interface IUserService09 {
    public List<Chart09> getChart09Payment(String title);
    public GsonOption getChart09Option();
    public String getWordcloudChartOption();
    public List<Chart09> getChart09Age();
}
