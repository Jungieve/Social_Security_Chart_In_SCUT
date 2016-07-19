package org.scut.mychart.mapper;


import org.scut.mychart.model.FunnelChart;
import org.scut.mychart.model.FunnelChartPay;

import java.util.List;
import java.util.Map;

public interface FunnelMapper {

    List<FunnelChart> selectFunnelNum();
    List<FunnelChartPay> selectFunnelPayment(Map<String,String> param);

}	

