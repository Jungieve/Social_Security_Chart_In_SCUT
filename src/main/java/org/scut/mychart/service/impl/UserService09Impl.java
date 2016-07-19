package org.scut.mychart.service.impl;

import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.WordCloud;
import org.scut.mychart.mapper.Charts09Mapper;
import org.scut.mychart.model.Chart09;
import org.scut.mychart.service.IUserService09;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("userService09")
public class UserService09Impl implements IUserService09 {

	@Resource
	private Charts09Mapper charts09Dao;

	public List<Chart09> getChart09Payment(String title){
		HashMap<String,String> param = new HashMap<String,String>();
		if(title=="job") {
			//param.put("table","ic15");
			param.put("title","job");
			param.put("type","aac012");
		}else if(title=="sex"){
			param.put("title","sex");
			param.put("type","aac004");
		}else if(title=="address"){
			param.put("title","address");
			param.put("type","aae006");
		}else if(title=="work"){
			param.put("title","work");
			param.put("type","aac008");
		} else{
			return null;
		}
		return this.charts09Dao.selectChart09Payment(param);
	}

	public List<Chart09> getChart09Age(){
		return this.charts09Dao.selectChart09Age(new HashMap());
	}

	public GsonOption getChart09Option(){

        GsonOption option = new GsonOption();

        option.title("江门市参保人数统计");
		option.tooltip().show(true);

		option.toolbox().show(true).feature(Tool.dataView,Tool.restore,Tool.saveAsImage);

        WordCloud person= new WordCloud();
		person.setName("江门市参保人数统计");
		//person.size("80%","80%");
		person.size("80%","80%");
		person.setTextRotation(new ArrayList<Integer>(Arrays.asList(0,45,90,-45)));
		person.setTextPadding(0);
		person.setAutoSize(new WordCloud.AutoSize(true,14));

		List<HashMap<String,Object>> data09 = new ArrayList<HashMap<String,Object>>();

		List<String> titles = new ArrayList<String>(Arrays.asList("job","sex","address","work","age"));
		List<Chart09> totalList = new ArrayList<Chart09>();
		//执行SQL语句得到所有的chart09
		for (String title:titles){
			//String color="rgb("+Math.round(Math.random()*160)+","+Math.round(Math.random()*160)+","+Math.round(Math.random()*160)+")";
			List<Chart09> chartList = new ArrayList<Chart09>();
			if (title.equals("age")){
				chartList = getChart09Age();
			}else{
				chartList = getChart09Payment(title);
			}
			for (Chart09 chart:chartList){
				chart.settitle(title);
				totalList.add(chart);
				//chart.setcolor(color);
			}
		}
		//将全部的chart09按人数排序
		Collections.sort(totalList, new Comparator<Chart09>() {
			public int compare(Chart09 o1, Chart09 o2) {
				return o2.getperson_num().compareTo(o1.getperson_num());
			}
		});

		//将每个Chart09加到data中
		for (Chart09 chart:totalList){
			HashMap<String,Object> currentMap09 = new HashMap<String, Object>();
			String color="rgb("+Math.round(Math.random()*160)+","+Math.round(Math.random()*160)+","+Math.round(Math.random()*160)+")";
			if (chart.gettitle().equals("job")){
				currentMap09.put("name",chart.getjob());
			}else if(chart.gettitle().equals("sex")){
				if (chart.getsex().equals("1")){
					currentMap09.put("name","男");
				}else {
					currentMap09.put("name","女");
				}
			}else if(chart.gettitle().equals("address")){
				currentMap09.put("name",chart.getaddress());
			}else if(chart.gettitle().equals("work")){
				currentMap09.put("name",chart.getwork());
			}else if(chart.gettitle().equals("age")){
				currentMap09.put("name",chart.getage());
				if (chart.getage().equals("60")){
					currentMap09.put("name","60岁以上");
				}else if (chart.getage().equals("50")){
					currentMap09.put("name","50-60岁");
				}else if (chart.getage().equals("40")){
					currentMap09.put("name","40-50岁");
				}else if (chart.getage().equals("30")){
					currentMap09.put("name","30-40岁");
				}else if (chart.getage().equals("20")){
					currentMap09.put("name","20-30岁");
				}else {
					currentMap09.put("name","20岁以下");
				}
			}
			currentMap09.put("value",chart.getperson_num());
			HashMap<String,HashMap<String,String>> itemStyle = new HashMap<String, HashMap<String,String>>();
			HashMap<String,String> normal = new HashMap<String, String>();
			normal.put("color",color);
			//normal.put("color",chart.getcolor());
			itemStyle.put("normal",normal);
			currentMap09.put("itemStyle",itemStyle);
			data09.add(currentMap09);
		}

		person.setData(data09);

		option.series(person);
        return option;
    }
}
