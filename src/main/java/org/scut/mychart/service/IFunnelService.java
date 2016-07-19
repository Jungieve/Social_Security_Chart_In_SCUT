package org.scut.mychart.service;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.FunnelChart;
import org.scut.mychart.model.FunnelChartPay;

import java.util.List;

public interface IFunnelService {
    

    public GsonOption getChart04Option();
    //public String getTitleName(String title);
    public List<FunnelChart> getFunnelChartList();
    public GsonOption getChart05Option(String title);
    public List<FunnelChartPay> getFunnelPayment(String tittle);
    public String getTittle(String tittle);
    
}
