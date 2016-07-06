package org.scut.mychart.service;

import java.util.List;

import org.scut.mychart.model.AC01;  
import org.scut.mychart.model.Chart01;

public interface IUserService {  
    public AC01 getAC01ById(String aac001); 
    public List<Chart01> getPayment(String title);
}
