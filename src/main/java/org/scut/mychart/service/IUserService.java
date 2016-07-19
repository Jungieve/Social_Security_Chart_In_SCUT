package org.scut.mychart.service;

import java.util.List;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.*;

import com.github.abel533.echarts.Option;

public interface IUserService {  
    
    public List<Chart01> getChart01Payment(String title);
    public List<Chart03> getChart03Charges();
    public int getChart10Personnum(String... tittle);
    
    public GsonOption getChart01Option(String title);
    public GsonOption getChart02Option(String title);
    public GsonOption getChart03Option();
   // public GsonOption getChart04Option(String title);

}
