package org.scut.mychart.controller;

import org.scut.mychart.model.MapChartModel;
import org.scut.mychart.model.RecommendResultModel;
import org.scut.mychart.service.MapChartService;
import org.scut.mychart.service.impl.RecommendServiceImpl;
import org.scut.mychart.util.DictionaryString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
@Controller
@RequestMapping(value = "/recommend",produces = "text/html;charset=UTF-8")
public class RecommendController {
    @Resource
    private RecommendServiceImpl recommendService;

    /**
     * 获取推荐结果
     * @param id
     * @return
     */
    @RequestMapping(value = "/result",produces = "application/json")
    @ResponseBody
    public Map<String, Object> getChartMap3dMarkBarOption(@RequestParam("id") String id){
        Map<String,Object> result=new HashMap<String,Object>();
        List<RecommendResultModel> recommendResultModelList =recommendService.getRecommendResult(id);
        result.put("data",recommendResultModelList);
        System.out.println(result);
        return result;
    }
}   

