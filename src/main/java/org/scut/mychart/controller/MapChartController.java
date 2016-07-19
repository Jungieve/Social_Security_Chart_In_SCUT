package org.scut.mychart.controller;

import com.github.abel533.echarts.json.GsonOption;
import org.scut.mychart.model.MapChartModel;
import org.scut.mychart.service.MapChartService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author gzw
 * 地图处理
 */
@Controller
@RequestMapping(value = "/charts",produces = "text/html;charset=UTF-8")
public class MapChartController {
    @Resource  
    private MapChartService chartMapService;
    @RequestMapping("/chartMapSub/{type}/{title}/{measure}")
    @ResponseBody
    public String getChartMapOptionSubAreaMode(@PathVariable String title,@PathVariable String type,@PathVariable String measure){
        GsonOption option = this.chartMapService.getChartMapOptionSubMode(title,type,measure);
        System.out.println(option.toString());
        return option.toString();  //view?
    }
    @RequestMapping("/chartMapMarkPoint/{type}/{title}/{measure}")
    @ResponseBody
    public String getChartMapOptionMarkPointMode(@PathVariable String title,@PathVariable String type,@PathVariable String measure){
        GsonOption option = this.chartMapService.getChartMapOptionMarkPointMode(title,type,measure);
        System.out.println(option.toString());
        return option.toString();  //view?
    }
    @RequestMapping("/chartMap/{type}/{title}/{measure}")
    @ResponseBody
    public String getChartMapOption(@PathVariable String title,@PathVariable String type,@PathVariable String measure){
        GsonOption option = this.chartMapService.getChartMapOption(title,type,measure);
        System.out.println(option.toString());
        return option.toString();  //view?
    }

    /**
     * 数据地图柱子模式，在前端封装option
     * @param title
     * @param type
     * @param measure
     * @return
     */
    @RequestMapping(value = "/chartMap3dMarkBar/{type}/{title}/{measure}",produces = "application/json")
    @ResponseBody
    public Map<String, Object> getChartMap3dMarkBarOption(@PathVariable String title,@PathVariable String type,@PathVariable String measure){



        java.util.Map<String,Object> result=new HashMap<String,Object>();

        List<MapChartModel> mapChartModelList =this.chartMapService.getMapChartList(title,type);

        List<String> yearList=new ArrayList();
        Map<String,List<Map>> data=new HashMap<String, List<Map>>();
        Double min=Double.MAX_VALUE;
        Double max=Double.MIN_VALUE;
        for(MapChartModel mapChartModel : mapChartModelList){
            String year=String.valueOf(mapChartModel.getYear());
            String area= mapChartModel.getArea().trim();
            Double value=null;
            if(measure.equals(DictionaryString.count))value= mapChartModel.getCount_person().doubleValue();
            else if (measure.equals(DictionaryString.avg)){value= mapChartModel.getAverage_money();}
            else value= mapChartModel.getTotal_money();
            List mapdataList=data.get(year);

            if(mapdataList==null){
                mapdataList=new ArrayList();
                data.put(year,mapdataList);
            }
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("name",area);
            map.put("value",value);
            double [] geo=DictionaryString.getGeoCoord(area);
            List geoCoord=new ArrayList();
            geoCoord.add(geo[0]);
            geoCoord.add(geo[1]);
            map.put("geoCoord", geoCoord);
            mapdataList.add(map);
            if(!yearList.contains(year)){
                yearList.add(year);
            }
            //计算最小值最大值为了拉开数值区分度，设置地图数据范围大小
            if(value>max)max=value;
            if(value<min)min=value;
        }

        result.put("yearList",yearList);
        result.put("data",data);
        result.put("min",min);
        result.put("max",max);
        System.out.println(result);
        return result;
    }

}   

