package org.scut.mychart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;  

import org.datanucleus.store.types.backed.Map;
import org.springframework.stereotype.Service;  
  
import org.scut.mychart.model.*;
import org.scut.mychart.mapper.*;
import org.scut.mychart.service.IUserService;  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private AC01Mapper ac01Dao;
    @Resource  
    private ChartsMapper chartsDao;
    
    public AC01 getAC01ById(String aac001) {  
        // TODO Auto-generated method stub  
        return this.ac01Dao.selectByPrimaryKey(aac001);  
    }  
    
    public List<Chart01> getChart01Payment(String tittle){
    	HashMap<String,String> param = new HashMap<String,String>();
    	if(tittle=="endowment") {
    		param.put("table","ic15");
    		param.put("payment","aic263");
    	}else if(tittle=="unemployment"){
    		param.put("table","jc14");
    		param.put("payment","ajc159");
    	}else if(tittle=="medical"){
    		param.put("table","kc24");
    		param.put("payment","akc263");
    	}else{
    		return null;
    	}
    	return this.chartsDao.selectChart01Payment(param);
    }
    
    public List<Chart03> getChart03Charges(){
    	return this.chartsDao.selectChart03Charges();
    }
    
    public int getChart10Personnum(String... tittle){
    	List<String> param = new ArrayList<String>();
    	for(String t:tittle){
    		if(t=="endowment") {
    			param.add("1_");
    		}else if(t=="unemployment"){
    			param.add("2_");
    		}else if(t=="medical"){
    			param.add("3_");
    		}else if(t=="injury"){
    			param.add("4_");
    		}else if(t=="birth"){
    			param.add("5_");
    		}
    	}
    	return this.chartsDao.selectChart10Personnum(param);
    }
}
