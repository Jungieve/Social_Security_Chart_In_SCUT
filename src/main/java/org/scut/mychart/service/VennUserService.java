package org.scut.mychart.service;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.Chartvenn;

public interface VennUserService {  
    

    
    public Chartvenn getChart10Personnum(String tittle1, String tittle2);
    
    public GsonOption getChartVennOption(String tittle1, String tittle2);
 
    
}
