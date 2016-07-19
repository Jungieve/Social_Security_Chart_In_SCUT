package org.scut.mychart.service.impl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Map;
import com.github.abel533.echarts.series.MarkPoint;
import org.scut.mychart.mapper.MapChartMapper;
import org.scut.mychart.model.MapChartModel;
import org.scut.mychart.service.MapChartService;
import org.scut.mychart.util.DictionaryString;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author gzw
 */
@Service("chartMapService")
public class MapChartServiceImpl implements MapChartService {
    @Resource  
    private MapChartMapper chartsDao;
	public String[] getNameArray(String title,String type,String op){
		String titlename= DictionaryString.getStringChinese(title);
		String typename= DictionaryString.getStringChinese(type);
		String charttitle="";
		String seriesname="";
		if(op.equals(DictionaryString.count)){
			charttitle=titlename+typename+"人员地区分布";
			seriesname=typename+"人数";
		} else if (op.equals(DictionaryString.avg)){
			charttitle=titlename+typename+"平均金额地区分布";
			seriesname=typename+"金额";
		} else {
			charttitle=titlename+typename+"总金额地区分布";
			seriesname=typename+"金额";
		}
		String[] result={charttitle,seriesname};
		return result;
	}
    public List<MapChartModel> getMapChartPayment(String title){
    	HashMap<String,String> param = new HashMap<String,String>();
    	if(title.equals(DictionaryString.endowment)) {
    		param.put("table","ic15");
    		param.put("payment","aic263");
    	}else if(title.equals(DictionaryString.unemployment)){
    		param.put("table","jc14");
    		param.put("payment","ajc159");
    	}else if(title.equals(DictionaryString.medical)){
    		param.put("table","kc24");
    		param.put("payment","akc263");
		}else if(title.equals(DictionaryString.injury)){
			param.put("table","wc44");
			param.put("payment","aic144");
		}else if(title.equals(DictionaryString.maternity)) {
			param.put("table","bc34");
			param.put("payment","aic144");
    	}else{
    		return null;
    	}
    	return this.chartsDao.selectMapChartPayment(param);
    }
    public List<MapChartModel> getMapChartCharges(String title){
		HashMap<String,String> param = new HashMap<String,String>();
		if(title.equals(DictionaryString.endowment)) {
			param.put("insurance_type","养老保险");
		}else if(title.equals(DictionaryString.unemployment)){
			param.put("insurance_type","失业保险");
		}else if(title.equals(DictionaryString.medical)){
			param.put("insurance_type","医疗保险");
		}else if(title.equals(DictionaryString.injury)){
			param.put("insurance_type","工伤保险");
		}else if(title.equals(DictionaryString.maternity)) {
			param.put("insurance_type", "生育保险");
		}else{
			return null;
		}
    	return this.chartsDao.selectMapChartCharges(param);
    }
	public List<MapChartModel> getMapChartList(String title, String type){
		if(type.equals(DictionaryString.payment))return getMapChartPayment(title);
		else if(type.equals(DictionaryString.charges)) return getMapChartCharges(title);
		else return null;
	}
	public GsonOption getChartMapOptionSubMode(String title,String type,String op) {
		String[][] xylocationlist={
				{"5%","10%"},{"55%","10%"},{"30%","10%"},{"76%","10%"},
				{"5%","50%"},{"55%","50%"},{"30%","50%"},{"85%","50%"}};
		String[] result=getNameArray(title,type,op);
		String charttitle=result[0];
		String seriesname=result[1];
		//process data
		List<MapChartModel> mapChartModelList =getMapChartList(title,type);
		java.util.Map<String,List<MapData>> data=new HashMap<String, List<MapData>>();
		List<String> yearList=new ArrayList();
		//记录数值范围,防止范围过大，颜色区分不明显。
		Integer max=Integer.MIN_VALUE;
		Integer min=Integer.MAX_VALUE;
		for(MapChartModel mapChartModel : mapChartModelList){
			String year=String.valueOf(mapChartModel.getYear());
			String area= mapChartModel.getArea().trim();
			Double measure=null;

			if(op.equals(DictionaryString.count))measure= mapChartModel.getCount_person().doubleValue();
			else if (op.equals(DictionaryString.avg)){measure= mapChartModel.getAverage_money();}
			else measure= mapChartModel.getTotal_money();

			List mapdataList=data.get(year);
			if(mapdataList==null){
				mapdataList=new ArrayList();
				data.put(year,mapdataList);
			}
			MapData mapData=new MapData(area,measure);
			mapdataList.add(mapData);
			if(!yearList.contains(year)){
				yearList.add(year);
			}
			if(min>measure){min=measure.intValue();}
			if(max<measure){max=measure.intValue();}
		}

		GsonOption optionGroup = new GsonOption(); //timeline option
		optionGroup.timeline()
				.autoPlay(true)
				.playInterval(1000)
				.setData(yearList);
		List<Option> options = new ArrayList<Option>();
		for(String year:yearList) {
			Option option = new Option();
			option.title().text(year + charttitle)
					.x(X.center);
			option.tooltip().trigger(Trigger.item);
//			option.legend().data("参保人口")
//					.x(X.left)
//					.orient(Orient.vertical);//图例
			//设置值域范围
			option.dataRange().min(min)
					.max(max)
					.x(xylocationlist[7][0])
					.y(xylocationlist[7][1])
					.text("高", "低")
					.calculable(true);
			option.toolbox()
					.show(true)
					.orient(Orient.vertical)
					.x(X.right)
					.y(Y.center)
					.feature( Tool.dataView, Tool.restore, Tool.saveAsImage);
			List<MapData> yeardataList=data.get(year);

			for(int index=0;index<yeardataList.size();index++) {
				MapData i=yeardataList.get(index);
				Map map = new Map();
				map.itemStyle().normal().label().setShow(true);
				map.itemStyle().emphasis().label().setShow(true);
				map.name(seriesname)
						.type(SeriesType.map)
						.mapType("jiangmen|"+i.getName())
						.roam(true)
						.data(i);
				map.mapLocation().width("22%")
						.height("35%")
						.x(xylocationlist[index][0])
						.y(xylocationlist[index][1]);
				option.series(map);
			}
			//add option
			options.add(option);
		}
		//set options
		optionGroup.options(options);
		return optionGroup;
	}
	public GsonOption getChartMapOption(String title,String type,String op) {
		String[] result=getNameArray(title,type,op);
		String charttitle=result[0];
		String seriesname=result[1];
		//process data
		List<MapChartModel> mapChartModelList =getMapChartList(title,type);
		java.util.Map<String,List<MapData>> data=new HashMap<String, List<MapData>>();
		List<String> yearList=new ArrayList<String>();
		//记录数值范围,防止范围过大，颜色区分不明显。
		Integer max=Integer.MIN_VALUE;
		Integer min=Integer.MAX_VALUE;
		for(MapChartModel mapChartModel : mapChartModelList){
			String year=String.valueOf(mapChartModel.getYear());
			String area= mapChartModel.getArea().trim();
			Double measure=null;

			if(op.equals(DictionaryString.count))measure= mapChartModel.getCount_person().doubleValue();
			else if (op.equals(DictionaryString.avg)){measure= mapChartModel.getAverage_money();}
			else measure= mapChartModel.getTotal_money();

			List mapdataList=data.get(year);
			if(mapdataList==null){
				mapdataList=new ArrayList();
				data.put(year,mapdataList);
			}
			MapData mapData=new MapData(area,measure);
			mapdataList.add(mapData);
			if(!yearList.contains(year)){
				yearList.add(year);
			}
			if(min>measure){min=measure.intValue();}
			if(max<measure){max=measure.intValue();}
		}

		GsonOption optionGroup = new GsonOption(); //timeline option
		optionGroup.timeline()
				.autoPlay(true)
				.playInterval(1000)
				.setData(yearList);
		List<Option> options = new ArrayList<Option>();
		for(String year:yearList) {
			Option option = new Option();
			option.title().text(year + charttitle)
					.x(X.center);
			option.tooltip().trigger(Trigger.item);
//			option.legend().data("参保人口")
//					.x(X.left)
//					.orient(Orient.vertical);//图例
			//设置值域范围
			option.dataRange().min(min)
					.max(max)
					.x(X.left)
					.y(Y.bottom)
					.text("高", "低")
					.calculable(true);
//			option.dataRange().color("#ff3333", "orange", "yellow","lime","aqua");
			option.toolbox()
					.show(true)
					.orient(Orient.vertical)
					.x(X.right)
					.y(Y.center)
					.feature( Tool.dataView, Tool.restore, Tool.saveAsImage);
			Map map = new Map();
			map.itemStyle().normal().label().setShow(true);
			map.itemStyle().normal().borderColor("white");
			map.itemStyle().normal().label().setShow(true);
//			map.itemStyle().normal().label().formatter("{a}:{b}");
			map.itemStyle().emphasis().label().setShow(true);
			map.name(seriesname)
					.type(SeriesType.map)
					.mapType("jiangmen")
					.roam(true)
					.setData(data.get(year));
			option.series(map);
			//add option
			options.add(option);
		}
		//set options
		optionGroup.options(options);
		return optionGroup;
	}
	public GsonOption getChartMapOptionMarkPointMode(String title,String type,String op) {
		String[] result=getNameArray(title,type,op);
		String charttitle=result[0];
		String seriesname=result[1];
		//process data
		List<MapChartModel> mapChartModelList =getMapChartList(title,type);
		java.util.Map<String,List<MapData>> data=new HashMap<String, List<MapData>>();
		List<String> yearList=new ArrayList<String>();
		//记录数值范围,防止范围过大，颜色区分不明显。
		Integer max=Integer.MIN_VALUE;
		Integer min=Integer.MAX_VALUE;
		for(MapChartModel mapChartModel : mapChartModelList){
			String year=String.valueOf(mapChartModel.getYear());
			String area= mapChartModel.getArea().trim();
			Double measure=null;

			if(op.equals(DictionaryString.count))measure= mapChartModel.getCount_person().doubleValue();
			else if (op.equals(DictionaryString.avg)){measure= mapChartModel.getAverage_money();}
			else measure= mapChartModel.getTotal_money();

			List mapdataList=data.get(year);
			if(mapdataList==null){
				mapdataList=new ArrayList();
				data.put(year,mapdataList);
			}
			MapData mapData=new MapData(area,measure);
			mapdataList.add(mapData);
			if(!yearList.contains(year)){
				yearList.add(year);
			}
			if(min>measure){min=measure.intValue();}
			if(max<measure){max=measure.intValue();}
		}

		GsonOption optionGroup = new GsonOption(); //timeline option
		optionGroup.timeline()
				.autoPlay(true)
				.playInterval(1000)
				.setData(yearList);
//		optionGroup.timeline().label().textStyle().color("#fff");
//		optionGroup.timeline().controlStyle().normal().color("#fff");
		List<Option> options = new ArrayList<Option>();
		for(String year:yearList) {
			Option option = new Option();
			option.color("gold","aqua","lime");
//			option.backgroundColor("#1b1b1b");
			option.title().text(year + charttitle)
					.x(X.center);
//			.textStyle().color("#fff");
			option.tooltip().trigger(Trigger.item);
//			option.legend().data("参保人口")
//					.x(X.left)
//					.orient(Orient.vertical);//图例
			//设置值域范围
			option.dataRange().min(min)
					.max(max)
					.x(X.left)
					.y(Y.bottom)
					.text("高", "低")
					.calculable(true)
					.textStyle();
//					.color("#fff");
			option.dataRange().color("#ff3333", "orange", "yellow","lime","aqua");
//			option.dataRange().color("maroon", "purple","red","orange", "yellow","lightgreen");

			option.toolbox()
					.show(true)
					.orient(Orient.vertical)
					.x(X.right)
					.y(Y.center)
					.feature( Tool.dataView, Tool.restore, Tool.saveAsImage);
			Map map = new Map();
			map.itemStyle().normal().label().setShow(true);
			map.itemStyle().normal().borderColor("rgba(100,149,237,1)");
//			map.itemStyle().normal().areaStyle().color("rgba(27, 27, 27, 0.0)");
			map.itemStyle().normal().label().setShow(true);
//			map.itemStyle().normal().label().formatter("{a}:{b}");
			map.itemStyle().emphasis().label().setShow(true);
			map.name(seriesname)
					.type(SeriesType.map)
					.mapType("jiangmen")
					.roam(true)
					.setData(new ArrayList());
//					.setData(data.get(year));

			MarkPoint markPoint=new MarkPoint();
			markPoint.symbol("emptyCircle")
					.effect().show(true).shadowBlur(0);
			markPoint.itemStyle().normal().label().setShow(true);
			markPoint.itemStyle().emphasis().label().position(Position.top);
			markPoint.setData(data.get(year));

			Integer m=(max-min)/7;
			markPoint.setSymbolSize("function (v){ return  (v-"
					+min.toString()
					+ ")/"
					+new Integer((max-min)/7).toString()
					+"*4+5;}");
			map.setMarkPoint(markPoint);
			map.geoCoord("台山市","112.793414","22.052956");
			map.geoCoord("恩平市","112.314051","22.250713");
			map.geoCoord("开平市","112.592262","22.450247");
			map.geoCoord("鹤山市","112.793414","22.638104");
			map.geoCoord("新会区","113.038584","22.366286");
			map.geoCoord("蓬江区","113.07859","22.65677");
			map.geoCoord("江海区","113.120601","22.560211");

			option.series(map);
			//add option
			options.add(option);
		}
		//set options
		optionGroup.options(options);
		return optionGroup;
	}

}

