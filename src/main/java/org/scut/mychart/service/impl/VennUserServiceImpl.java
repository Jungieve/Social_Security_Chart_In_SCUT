package org.scut.mychart.service.impl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Venn;
import org.scut.mychart.mapper.VennChartsMapper;
import org.scut.mychart.model.ChartTypeConstant;
import org.scut.mychart.model.Chartvenn;
import org.scut.mychart.redis.VennRediaDao;
import org.scut.mychart.service.VennUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class VennUserServiceImpl implements VennUserService {
	@Autowired
     private VennChartsMapper chartsDao;
    @Autowired
    private VennRediaDao vennRedisDao;


      public Chartvenn getChart10Personnum(String tittle1, String tittle2){
            HashMap<String,String> param = new HashMap<String,String>();
            if(tittle1.equals("endowment")) {
                param.put("table1","ic15");

            }
            if(tittle1.equals("unemployment")){
                param.put("table1","jc14");

            }
            if(tittle1.equals("medical")){
                param.put("table1","kc24");

            }
            if(tittle1.equals("shengyu")){
              param.put("table1","bc34");

            }
            if(tittle1.equals("gongshang")){
              param.put("table1","wc44");

            }
            if(tittle2.equals("endowment")) {
                param.put("table2","ic15");

            }
            if(tittle2.equals("unemployment")){
                param.put("table2","jc14");

            }
            if(tittle2.equals("medical")){
                param.put("table2","kc24");

            }
            if(tittle2.equals("shengyu")){
              param.put("table2","bc34");

             }
            if(tittle2.equals("gongshang")){
              param.put("table2","wc44");

            }
            Integer a = this.chartsDao.selectChart10Personnum1(param);
            Integer b = this.chartsDao.selectChart10Personnum2(param);
            Integer c = this.chartsDao.selectChart10Personnum3(param);
          Chartvenn chart=new Chartvenn();
          chart.setperson_num1(a);
          chart.setperson_num2(b);
          chart.setperson_num3(c);
          return chart;
        }

    public String getChartVennOption(String tittle1,String tittle2) {
        // TODO Auto-generated method stub
        String type = ChartTypeConstant.Radar_REDIS;
        GsonOption option = new GsonOption();
        Option option1 = new GsonOption();
        Option option2 = new GsonOption();
        Option option3 = new GsonOption();
        String name1="endowment";
        String name2="gongshang";
        String name3="medical";
        String name11="养老保险";
        String name22="工伤保险";
        String name33="医疗保险";

        Chartvenn list1=getChart10Personnum(tittle1,tittle2);
        Chartvenn list2=getChart10Personnum(name1,name2);
        Chartvenn list3=getChart10Personnum(name3,name1);
        option.title("社保缴费韦恩图");
        option.calculable(true);
        Venn data1=new Venn();
        Venn data2=new Venn();
        Venn data3=new Venn();
        HashMap<String, Object> tem = new HashMap<String, Object>();
        String nametrasfer01="";
        String nametrasfer02="";
        if(tittle1.equals("endowment")) {
            nametrasfer01="养老保险";

        }
        if(tittle1.equals("unemployment")){
            nametrasfer01="失业保险";

        }
        if(tittle1.equals("medical")){
            nametrasfer01="医疗保险";

        }
        if(tittle1.equals("shengyu")){
            nametrasfer01="生育保险";

        }
        if(tittle1.equals("gongshang")){
            nametrasfer01="工伤保险";

        }
        if(tittle2.equals("endowment")) {
            nametrasfer02="养老保险";

        }
        if(tittle2.equals("unemployment")){
            nametrasfer02="失业保险";

        }
        if(tittle2.equals("medical")){
            nametrasfer02="医疗保险";

        }
        if(tittle2.equals("shengyu")){
            nametrasfer02="生育保险";

        }
        if(tittle2.equals("gongshang")){
            nametrasfer02="工伤保险";

        }
        option.timeline().data("1","2").zlevel(0);
        List<Option> optionlist=new ArrayList <Option>();
        tem.put("value",list1.getperson_num1());tem.put("name",nametrasfer01);
        data1.data(tem);
        tem = new HashMap<String, Object>();
        tem.put("value",list1.getperson_num2());tem.put("name",nametrasfer02);
        data1.data(tem);
        tem = new HashMap<String, Object>();
        tem.put("value",list1.getperson_num3());tem.put("name","公共");
        data1.data(tem);
        data1.itemStyle().normal().label().show(true).textStyle().fontFamily("Arial, Verdana, sans-serif").fontSize(16).fontWeight("bolder");
        data1.itemStyle().normal().labelLine().show(false).length(10).lineStyle().width(1).type(LineType.solid);
        data1.itemStyle().emphasis().color("#cc99cc").borderWidth(3).borderColor("#996699");
        option1.series(data1);
        option1.tooltip().trigger(Trigger.item).formatter("{b}: {c}");
        optionlist.add(option1);

        /*tem = new HashMap<String, Object>();
        tem.put("value",list2.getperson_num1());tem.put("name",name11);
        data2.data(tem);
        tem = new HashMap<String, Object>();
        tem.put("value",list2.getperson_num2());tem.put("name",name22);
        data2.data(tem);
        tem = new HashMap<String, Object>();
        tem.put("value",list2.getperson_num3());tem.put("name","公共");
        data2.data(tem);
        data2.itemStyle().normal().label().show(true).textStyle().fontFamily("Arial, Verdana, sans-serif").fontSize(16).fontWeight("bolder");
        data2.itemStyle().normal().labelLine().show(false).length(10).lineStyle().width(1).type(LineType.solid);
        data2.itemStyle().emphasis().color("#cc99cc").borderWidth(3).borderColor("#996699");
        data2.data(tem);
        option2.tooltip().trigger(Trigger.item).formatter("{b}: {c}");
        option2.series(data2);
        optionlist.add(option2);*/

        tem = new HashMap<String, Object>();
        tem.put("value",list3.getperson_num1());tem.put("name",name33);
        data3.data(tem);
        tem = new HashMap<String, Object>();
        tem.put("value",list3.getperson_num2());tem.put("name",name11);
        data3.data(tem);
        tem = new HashMap<String, Object>();
        tem.put("value",list3.getperson_num3());tem.put("name","公共");
        data3.data(tem);
        data3.itemStyle().normal().label().show(true).textStyle().fontFamily("Arial, Verdana, sans-serif").fontSize(16).fontWeight("bolder");
        data3.itemStyle().normal().labelLine().show(false).length(10).lineStyle().width(1).type(LineType.solid);
        data3.itemStyle().emphasis().color("#cc99cc").borderWidth(3).borderColor("#996699");
        option3.tooltip().trigger(Trigger.item).formatter("{b}: {c}");
        option3.series(data3);
        optionlist.add(option3);

        option.options(optionlist);
        vennRedisDao.setVennData(type, option.toString());

        System.out.println(option.toString());

        return option.toString();
    }



}

