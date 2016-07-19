package org.scut.mychart.controller;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.service.VennUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller  
@RequestMapping(value = "/charts",produces = "text/html;charset=UTF-8")
public class ChartvennController {
    @Resource  
    private VennUserService vennUserService;
      
    @RequestMapping("/chartvenn")
    @ResponseBody
    public String toIndex(){
        GsonOption option = this.vennUserService.getChartVennOption("endowment","unemployment");
        System.out.println(option.toString());
        return option.toString();  //view?
    }  
}