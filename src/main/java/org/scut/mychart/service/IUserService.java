package org.scut.mychart.service;

import java.util.List;

import org.scut.mychart.model.*;

public interface IUserService {  
    public AC01 getAC01ById(String aac001); 
    public List<Chart01> getChart01Payment(String title);
    public List<Chart03> getChart03Charges();
    public int getChart10Personnum(String... tittle);
}
