package org.scut.mychart.controller;

import javax.annotation.Resource;
import javax.jws.WebResult;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.scut.mychart.model.AC01;  
import org.scut.mychart.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.echarts.Option;

@Controller  
@RequestMapping("/charts")  
public class Chart01Controller {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/chart01")
    @ResponseBody
    public Option toIndex(HttpServletRequest request,Model model){

    	Option option = this.userService.getChart01Option("endowment");
    	model.addAttribute("data", option); 
        return option;  //view?

    }  
}  
