package org.scut.testmybatis;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Before;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
import com.alibaba.fastjson.JSON;  
import org.scut.mychart.model.AC01;  
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
        AC01 ac01 = userService.getAC01ById("0010161257");  
        System.out.println(ac01.getAac005());  
        logger.info("springMVC test:"+ac01.getAac005());  
        logger.info(JSON.toJSONString(ac01));  
    }  
} 