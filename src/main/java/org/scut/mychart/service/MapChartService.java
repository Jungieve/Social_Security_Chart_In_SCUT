package org.scut.mychart.service;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.MapChartModel;

import java.util.List;

/**
 * @author gzw
 */
public interface MapChartService {
    /**
     * 获取支付信息年度区域分布
     * @param title
     * @return
     */
    public List<MapChartModel>getMapChartPayment(String title);

    /**
     * 获取缴费信息年度区域分布
     * @param title
     * @return
     */
    public List<MapChartModel> getMapChartCharges(String title);

    /**
     * 获取年度区域分布信息
     * @param title
     * @param type
     * @return
     */
    public List<MapChartModel> getMapChartList(String title, String type);
    /**
     * 获取子区域地图option
     * @param title 险种类型
     * @param type  缴费：charges,支付:payment
     * @param option 人口计数：count，金额求和：sum，金额求均：avg
     * @return
     */
    public String getChartMapOptionSubMode(String title,String type,String option);

    /**
     * 获取标准地图option
     * @param title 险种类型
     * @param type  缴费：charges,支付:payment
     * @param option 人口计数：count，金额求和：sum，金额求均：avg
     * @return
     */
    public String getChartMapOption(String title,String type,String option);

    /**
     * 获取炫光特效地图option
     * @param title 险种类型
     * @param type  缴费：charges,支付:payment
     * @param option 人口计数：count，金额求和：sum，金额求均：avg
     * @return
     */
    public String getChartMapOptionMarkPointMode(String title,String type,String option);

}
