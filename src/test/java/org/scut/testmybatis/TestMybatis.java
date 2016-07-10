package org.scut.testmybatis;

import java.util.List;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonOption;

import org.scut.mychart.model.*;
import org.scut.mychart.service.IUserService;  
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMybatis {  
    private static Logger logger = Logger.getLogger(TestMybatis.class);  
//    private ApplicationContext ac = null;  
    @Resource  
    private IUserService userService = null;  
  
//    @Before  
//    public void before() {  
//        ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"});  
//        userService = (IUserService) ac.getBean("userService");  
//    }  
  
    @Test  
    public void test1() {  
//      AC01 ac01 = userService.getAC01ById("0010161257");  
//      System.out.println(ac01.getAac005());  
//      logger.info("springMVC test:"+ac01.getAac005());  
//      logger.info(JSON.toJSONString(ac01));  
//  	Option option = userService.getChart01Option("endowment");
//		Option option = userService.getChart02Option("endowment");
		GsonOption option = userService.getChart03Option();
		logger.info(JSON.toJSONString(option,true)); 
		logger.info(option.toString());
//    	 List<Chart03> chart03 = userService.getChart03Payment();
//         JSONArray json = new JSONArray();
//         for(Chart03 c : chart03){
//             JSONObject jo = new JSONObject();
//             try {
// 				jo.put("sex", c.getsex());
// 				jo.put("year", c.getyear());
// 				jo.put("person_num", c.getperson_num());
// 				jo.put("total_payment", c.gettotal_payment());
//             } catch (JSONException e) {
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}
//             json.put(jo);
//         }
//         logger.info(json.toString());
    } 
    
    @Test  
    public void test3() {  
//        AC01 ac01 = userService.getAC01ById("0010161257");  
//        System.out.println(ac01.getAac005());  
        List<Chart03> chart03 = userService.getChart03Charges();
        JSONArray json = new JSONArray();
        for(Chart03 c : chart03){
            JSONObject jo = new JSONObject();
            try {
				jo.put("sex", c.getsex());
				jo.put("year", c.getyear());
				jo.put("person_num", c.getperson_num());
				jo.put("total_charges", c.gettotal_charges());
            } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            json.put(jo);
        }
        //System.out.println(chart01);
        //logger.info("springMVC test:"+ac01.getAac005());  
        logger.info(json.toString());
        //logger.info(JSON.toJSONString(chart01, true));
    }
} 