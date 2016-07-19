package org.scut.mychart.controller;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.service.IUserService09;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
//echarts字符云
@Controller  
@RequestMapping(value = "/charts",produces = "text/html;charset=UTF-8")
public class Chart09Controller {
    @Resource
    private IUserService09 userService09;
      
    @RequestMapping("/chart09")
    @ResponseBody
    public String toIndex(){
        GsonOption option = this.userService09.getChart09Option();
        System.out.println(option.toString());
        return option.toString();  //view?
    }  
}   

