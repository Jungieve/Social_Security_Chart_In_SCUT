package org.scut.mychart.controller;

import javax.annotation.Resource;
import javax.jws.WebResult;
import javax.servlet.http.HttpServletRequest;

import com.github.abel533.echarts.json.GsonOption;

import org.scut.mychart.service.IFunnelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/chart01/{tittle}")
    @ResponseBody
    public String toIndex(@PathVariable String tittle) {
//        GsonOption option = this.userService.getChart01Option(tittle);
    	String data = this.userService.getChart01Option(tittle);
        System.out.println(data);
        return data;  //view?
    }
    
    @RequestMapping("/chart02/{tittle}")
    @ResponseBody
    public String getChart02(@PathVariable String tittle) {
//    	GsonOption option = this.userService.getChart02Option(tittle);
    	String data = this.userService.getChart02Option(tittle);
    	System.out.println(data);
    	return data;  //view?
    }
    
    @RequestMapping("/chart03")
    @ResponseBody
    public String getChart03() {
//    	GsonOption option = this.userService.getChart03Option();
    	String data = this.userService.getChart03Option();
    	System.out.println(data);
    	return data;  //view?
    }
}






