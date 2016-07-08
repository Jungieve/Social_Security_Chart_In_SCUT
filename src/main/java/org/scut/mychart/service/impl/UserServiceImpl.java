package org.scut.mychart.service.impl;

import com.github.abel533.echarts.Data;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.data.SeriesData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;

import org.scut.mychart.mapper.AC01Mapper;
import org.scut.mychart.mapper.ChartsMapper;
import org.scut.mychart.model.AC01;
import org.scut.mychart.model.Chart01;
import org.scut.mychart.model.Chart03;
import org.scut.mychart.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private AC01Mapper ac01Dao;
    @Resource  
    private ChartsMapper chartsDao;
    
    public AC01 getAC01ById(String aac001) {  
        // TODO Auto-generated method stub  
        return this.ac01Dao.selectByPrimaryKey(aac001);  
    }  
    
    public List<Chart01> getChart01Payment(String tittle){
    	HashMap<String,String> param = new HashMap<String,String>();
    	if(tittle=="endowment") {
    		param.put("table","ic15");
    		param.put("payment","aic263");
    	}else if(tittle=="unemployment"){
    		param.put("table","jc14");
    		param.put("payment","ajc159");
    	}else if(tittle=="treatment"){
    		param.put("table","kc24");
    		param.put("payment","akc263");
    	}else{
    		return null;
    	}
    	return this.chartsDao.selectChart01Payment(param);
    }
    
    public GsonOption getChart01Option(String title){

		GsonOption option = new GsonOption();
    	List<Chart01> list = getChart01Payment(title);
    	
    	option.title("社保待遇支付统计");  
    	option.tooltip().trigger(Trigger.axis);
    	option.legend().data("男","女");
    	option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.bar),
    			Tool.restore, Tool.saveAsImage);
    	option.calculable(true);
    	
    	//生成category 和 series
    	List<HashMap<String,Integer>> data = new ArrayList<HashMap<String,Integer>>();
    	
    	CategoryAxis category = new CategoryAxis(); 
    	Bar male = new Bar();
    	Bar female = new Bar();
  
    	HashMap<String,Integer> currentMap = new HashMap<String, Integer>();
    	double malePayment = 0.0;
    	double femalePayment = 0.0;
    	//sum
    	for(Chart01 chart:list){
    		
    		if(!currentMap.containsKey("year") || currentMap.get("year").intValue()!=chart.getyear().intValue()){

    			if(currentMap.containsKey("year")){
        			currentMap.put("male", new Double(malePayment).intValue());
        			currentMap.put("female", new Double(femalePayment).intValue());
        			data.add(currentMap);
        			System.out.println("year: "+currentMap.get("year").intValue()+
        					", male:　"+currentMap.get("male").intValue()+
        					", female: "+currentMap.get("female").intValue());
    			}
    	    	malePayment = 0.0;
    	    	femalePayment = 0.0;
    			currentMap = new HashMap<String, Integer>();
    			currentMap.put("year", chart.getyear());
    		}
    		
    		if(chart.getsex().equals("1")){
    			malePayment += chart.gettotal_payment();
    		}
    		else{
    			femalePayment += chart.gettotal_payment();
    		}
    		
    	}
		currentMap.put("male", (int)malePayment);
		currentMap.put("female", (int)femalePayment);
		data.add(currentMap);
		System.out.println("year: "+currentMap.get("year").intValue()+
				", male:　"+currentMap.get("male").intValue()+
				", female: "+currentMap.get("female").intValue());
		
		
		int max1=0,min1=0,max2=0,min2=0,count=0;
		double avg1=0.0,sum1=0.0,avg2=0.0,sum2=0.0;

		//for each year
		for(HashMap<String,Integer> map:data){
			
			category.data(map.get("year")+"年");
			male.data(map.get("male"));
			female.data(map.get("female"));
			sum1 += map.get("male");
			sum2 += map.get("female");
			if(max1 < map.get("male")){
				max1 = map.get("male");
			}
			if(min1 > map.get("male")){
				min1 = map.get("male");
			}
			if(max2 < map.get("female")){
				max2 = map.get("female");
			}
			if(min2 > map.get("female")){
				min2 = map.get("female");
			}
			count++;
		}
    	avg1 = sum1/count;
    	avg2 = sum2/count;
    	male.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
    	male.markLine().data(new PointData().type(MarkType.average).name("平均值"));
    	female.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
    	female.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		male.name("男");  
		female.name("女");
		
		option.xAxis(category);
    	option.yAxis(new ValueAxis());  //金额
	    option.series(male,female);
    	
    	return option;
    }
    
    
    //应用2
    public GsonOption getChart02Option(String title){
    	
    	GsonOption option = new GsonOption();
    	
    	List<Chart01> list = getChart01Payment(title);
    	
    	option.title("社保待遇支付统计");  
    	option.tooltip().trigger(Trigger.axis);
    	option.legend().data("男","女","人数");
    	option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line,Magic.stack,Magic.tiled),
    			Tool.restore, Tool.saveAsImage);
    	option.calculable(true);
    	
    	//生成category 和 series
    	List<HashMap<String,Integer>> data = new ArrayList<HashMap<String,Integer>>();
    	
    	CategoryAxis category = new CategoryAxis(); 
    	Line male = new Line();
    	Line female = new Line();
    	Line total = new Line();
  
    	HashMap<String,Integer> currentMap = new HashMap<String, Integer>();
    	int maleNum = 0;
    	int femaleNum = 0;
    	//sum
    	for(Chart01 chart:list){
    		
    		if(!currentMap.containsKey("year") || currentMap.get("year").intValue()!=chart.getyear().intValue()){

    			if(currentMap.containsKey("year")){
        			currentMap.put("male", maleNum);
        			currentMap.put("female", femaleNum);
        			currentMap.put("total", maleNum + femaleNum);
        			data.add(currentMap);
        			System.out.println("year: "+currentMap.get("year").intValue()+
        					", male:　"+currentMap.get("male").intValue()+
        					", female: "+currentMap.get("female").intValue());
    			}
    			maleNum = 0;
    			femaleNum = 0;
    			currentMap = new HashMap<String, Integer>();
    			currentMap.put("year", chart.getyear());
    		}
    		
    		if(chart.getsex().equals("1")){
    			maleNum += chart.getperson_num();
    		}
    		else{
    			femaleNum += chart.getperson_num();
    		}
    		
    	}
		currentMap.put("male", maleNum);
		currentMap.put("female", femaleNum);
		currentMap.put("total", maleNum+femaleNum);
		data.add(currentMap);
		System.out.println("year: "+currentMap.get("year").intValue()+
				", male:　"+currentMap.get("male").intValue()+
				", female: "+currentMap.get("female").intValue());
		

		//for each year
		for(HashMap<String,Integer> map:data){
			
			category.data(map.get("year")+"年");
			male.data(map.get("male"));
			female.data(map.get("female"));
			total.data(map.get("total"));
		}

		male.name("男").stack("总量");  
		female.name("女").stack("总量");
		total.name("人数").stack("总量");
		
		option.xAxis(category);
    	option.yAxis(new ValueAxis());  //人数
	    option.series(male,female,total);
	    
    	return option;
    }
    
    //应用3
    public List<Chart03> getChart03Payment(){
    	return this.chartsDao.selectChart03Payment(new HashMap());
    }
    
    public GsonOption getChart03Option(){
    	
    	GsonOption optionGroup = new GsonOption(); //timeline option
    	
    	//process data
    	List<Chart03> chartList = getChart03Payment();
    	ArrayList<ArrayList<Integer>> dataList = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<String>> occupationList = new ArrayList<ArrayList<String>>();
    	ArrayList<Integer> currentCount = new ArrayList<Integer>();
    	ArrayList<String> currentOccupation = new ArrayList<String>();
    	
    	int maxIndex = 0;
    	for(Chart03 chart : chartList){
    		
    		if(currentCount.size()!=0 && currentCount.get(0).intValue() != chart.getyear().intValue()){
    			dataList.add(currentCount);
    			occupationList.add(currentOccupation);
    			if(occupationList.get(maxIndex).size()<currentOccupation.size()){
    				maxIndex = occupationList.size()-1;
    			}
    			currentCount = new ArrayList<Integer>();
    			currentOccupation = new ArrayList<String>();
    		}
    		if(currentCount.size()==0){
    			currentCount.add(chart.getyear().intValue());
    			currentCount.add(0);//male  index =1
    			currentCount.add(0);//female  index =2
    		}
    		if(currentOccupation.size()==0 || !currentOccupation.get(currentOccupation.size()-1).equals(chart.getoccupation())){
    			currentOccupation.add(chart.getoccupation());
    			currentCount.add(0);
    		}
    		//occupation count
    		currentCount.set(currentOccupation.size()-1+3, currentCount.get(currentOccupation.size()-1+3)+chart.getperson_num());
    		//sex count
    		if(chart.getsex().equals("1")){
    			currentCount.set(1, currentCount.get(1)+chart.getperson_num());
    		}
    		else{
    			currentCount.set(2, currentCount.get(2)+chart.getperson_num());
    		}
    	}
    	if(currentOccupation.size()>0){
        	dataList.add(currentCount);
    		occupationList.add(currentOccupation);
    	}
		if(occupationList.get(maxIndex).size()<currentOccupation.size()){
			maxIndex = occupationList.size()-1;
		}
		
		List<Option> options = new ArrayList<Option>();
		Option option = new Option();
		option.title("社保人员占比分析");  
    	option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
    	for(int i=0;i<occupationList.get(maxIndex).size();i++){
    		option.legend().data(occupationList.get(maxIndex).get(i));//("工人","干部","居民","男","女");
    	}
    	option.legend().data("男","女");
    	option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.pie,Magic.funnel),
    			Tool.restore, Tool.saveAsImage);
    	option.calculable(true);

    	//timeline.data  series
		for(int i=0;i<dataList.size();i++){
			
			//timeline
			optionGroup.timeline().data(dataList.get(i).get(0).intValue()+"年");
			
			//series
			Pie occupation = new Pie();
			occupation.name("职业");
			occupation.radius("50%");
			occupation.center("30%","45%");
			Pie sex = new Pie();
			sex.name("性别");
			sex.radius("50%");
			sex.center("70%","45%");
			for(int j=0;j<occupationList.get(i).size();j++){
				occupation.data(new PieData(occupationList.get(i).get(j), dataList.get(i).get(j+3)));
			}
			sex.data(new PieData("男", dataList.get(i).get(1)));
			sex.data(new PieData("女", dataList.get(i).get(2)));
			option.series(occupation,sex);
			
			//add option
			options.add(option);
			option = new Option();
		}
		//set options
		optionGroup.options(options);
    	
    	return optionGroup;
    }
    
}
