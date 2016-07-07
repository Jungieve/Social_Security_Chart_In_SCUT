package org.scut.mychart.service;

import java.util.List;

import org.scut.mychart.model.*;

import com.github.abel533.echarts.Option;

public interface IUserService {  
    public AC01 getAC01ById(String aac001); 
    
    public List<Chart01> getChart01Payment(String title);
    public Option getChart01Option(String title);
    
    public Option getChart02Option(String title);
    
    public List<Chart03> getChart03Payment();
    
}
