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
/**
 * Created by chenlin on 2016/7/13.
 */
@Controller
@RequestMapping(value = "/charts",produces = "text/html;charset=UTF-8")
public class FunnelController {
        @Resource
        private IFunnelService funnelService;

        @RequestMapping("/funnelchart")
        @ResponseBody
        public String toIndex() {
            GsonOption option = this.funnelService.getChart04Option();
            System.out.println(option.toString());
            return option.toString();
        }

        @RequestMapping("/funnelChartPay/{tittle}")
        @ResponseBody
        public String toIndex1(@PathVariable String tittle){
            GsonOption option=this.funnelService.getChart05Option(tittle);
            System.out.println(option.toString());
            return option.toString();
        }



}
