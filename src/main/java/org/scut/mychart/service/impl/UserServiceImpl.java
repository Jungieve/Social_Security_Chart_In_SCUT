package org.scut.mychart.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
  
import org.scut.mychart.model.AC01; 
import org.scut.mychart.model.Chart01;
import org.scut.mychart.mapper.AC01Mapper;  
import org.scut.mychart.mapper.Chart01Mapper;
import org.scut.mychart.service.IUserService;  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource
    private AC01Mapper ac01Dao;
    @Resource
    private Chart01Mapper chart01Dao;
    
    public AC01 getAC01ById(String aac001) {  
        // TODO Auto-generated method stub  
        return this.ac01Dao.selectByPrimaryKey(aac001);  
    }  
    
    public List<Chart01> getPayment(String title){
    	return this.chart01Dao.selectPayment(new HashMap<String,String>(){
    		{put("table","kc24");put("payment","akc263");}});
    }
}
