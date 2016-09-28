package org.scut.mychart.service.impl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Map;
import com.github.abel533.echarts.series.MarkPoint;
import org.scut.mychart.mapper.MapChartMapper;
import org.scut.mychart.mapper.RecommendMapper;
import org.scut.mychart.model.MapChartModel;
import org.scut.mychart.model.RecommendResultModel;
import org.scut.mychart.redis.MapRedisDao;
import org.scut.mychart.service.MapChartService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gzw
 */
@Service("recommendService")
public class RecommendServiceImpl  {
    @Resource  
    private RecommendMapper recommendDao;

    public List<RecommendResultModel> getRecommendResult(String id){
    	HashMap<String,String> param = new HashMap<String,String>();
    	param.put("id",id);
    	return recommendDao.selectRecommendResult(param);
    }
}

