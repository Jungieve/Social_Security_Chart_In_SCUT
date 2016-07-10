package org.scut.mychart.controller;

import javax.annotation.Resource;
import javax.jws.WebResult;
import javax.servlet.http.HttpServletRequest;

import com.github.abel533.echarts.json.GsonOption;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.scut.mychart.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.echarts.Option;

import com.github.abel533.echarts.Option;

@Controller  
@RequestMapping(value = "/charts",produces = "text/html;charset=UTF-8")
public class Chart01Controller {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/chart01")
    @ResponseBody
    public String toIndex(){
        GsonOption option = this.userService.getChart01Option("endowment");
        System.out.println(option.toString());
        return option.toString();  //view?
    }  
}   

