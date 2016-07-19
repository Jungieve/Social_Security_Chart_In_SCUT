package org.scut.mychart.controller;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.ChartRadar;
import org.scut.mychart.service.ChartRadarService;
import org.scut.mychart.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller  
@RequestMapping(value = "/charts",produces = "text/html;charset=UTF-8")
public class ChartRadarController {
    @Resource  
    private ChartRadarService chartRadarService;
      
    @RequestMapping("/chartRadar")
    @ResponseBody
    public String toIndex(){
        GsonOption option = this.chartRadarService.getChartRadarOption();
        System.out.println(option.toString());
        return option.toString();  //view?
    }  
}   

