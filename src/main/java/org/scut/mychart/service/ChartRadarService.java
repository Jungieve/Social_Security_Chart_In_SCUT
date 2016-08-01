package org.scut.mychart.service;

import java.util.List;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.*;

import com.github.abel533.echarts.Option;

public interface ChartRadarService {

    public List<ChartRadar> getChartRadarData();
    public Integer getTypeint(String type);
    public String getChartRadarOption();
}
