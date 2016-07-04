package org.scut.mychart.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
  
import org.scut.mychart.model.AC01; 
import org.scut.mychart.mapper.AC01Mapper;  
import org.scut.mychart.service.IUserService;  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private AC01Mapper ac01Dao;  
    @Override  
    public AC01 getAC01ById(String aac001) {  
        // TODO Auto-generated method stub  
        return this.ac01Dao.selectByPrimaryKey(aac001);  
    }  
    
}
