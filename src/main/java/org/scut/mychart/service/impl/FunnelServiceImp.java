package org.scut.mychart.service.impl;

/**
 * Created by chenlin on 16/7/12.
 */

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.*;

import org.scut.mychart.mapper.FunnelMapper;
import org.scut.mychart.model.FunnelChart;
import org.scut.mychart.model.FunnelChartPay;
import org.scut.mychart.service.IFunnelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map;

@Service("funnelService")
public class FunnelServiceImp implements IFunnelService {
    @Resource
    private FunnelMapper chartsDao;

    //拼接标题
    public String getTittle(String tittle) {
        String text=" ";
        if (tittle.equals("endowment")){
            text="养老保险";
            return text;
        }else if (tittle.equals("unemployment")){
            text="失业保险";
            return text;
        }else if (tittle.equals("medical")){
            text="医疗保险";
            return text;
        }else if (tittle.equals("injury")){
            text="工伤保险";
            return text;
        }else if (tittle.equals("maternity")){
            text="生育保险";
            return text;
        }else{
            return null;
        }
    }

    //匹配不同的险种，取出相关字段及表，返回支付统计数据对象
    public List<FunnelChartPay> getFunnelPayment(String tittle){
        HashMap<String,String> param = new HashMap<String,String>();
      //  HashMap<String,String> param = new HashMap<String,String>();
        if(tittle.equals("endowment")) {
            param.put("table","ic15");
            param.put("payment","aic263");
        }else if(tittle.equals("unemployment")){
            param.put("table","jc14");
            param.put("payment","ajc159");
        }else if(tittle.equals("medical")){
            param.put("table","kc24");
            param.put("payment","akc263");
        }else if(tittle.equals("injury")){
            param.put("table","wc44");
            param.put("payment","aic144");
        }else if (tittle.equals("maternity")){
            param.put("table","bc34");
            param.put("payment","aic144");
        }
        else{
            return null;
        }
        return this.chartsDao.selectFunnelPayment(param);
    }

    //返回人数数据对象
    public List<FunnelChart> getFunnelChartList(){
        return this.chartsDao.selectFunnelNum();
    }

    //人数统计option
    public GsonOption getChart04Option() {
        GsonOption optionGroup = new GsonOption();

        List<FunnelChart> funnelList=getFunnelChartList();
        java.util.Map<String,List<MapData>> data=new HashMap<String, List<MapData>>();
        List<String> yearList=new ArrayList();

        for(FunnelChart funnelChart:funnelList){
            String year=String.valueOf(funnelChart.getYear());
            String birth=funnelChart.getBirth().trim();
            Integer count_person=funnelChart.getPerson_num();
            List mapdataList=data.get(year);
            if(mapdataList==null){
                mapdataList=new ArrayList();
                data.put(year,mapdataList);
            }
            MapData mapData=new MapData(birth,count_person);
            mapdataList.add(mapData);
            if(!yearList.contains(year)){
                yearList.add(year);
            }
        }

        java.util.Map<String,List<MapData>> data1=new HashMap<String, List<MapData>>();
        int sum=0,sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0;
        double rat1=0.0,rat2=0.0,rat3=0.0,rat4=0.0,rat5=0.0,rat6=0.0;

        for(String year:yearList){
            List <MapData>dataList=data.get(year);
            for(MapData list01:dataList){
                String birth=list01.getName();
                Integer num=(Integer)list01.getValue();
                int birthyear=Integer.valueOf(birth).intValue();
                if(birthyear>=1981 && birthyear<=1998){
                    sum1+=num;
                }
                if(birthyear>=1971&&birthyear<=1980){
                    sum2+=num;
                }
                if(birthyear>=1961&&birthyear<=1970){
                    sum3+=num;
                }
                if(birthyear>=1946&&birthyear<=1960){
                    sum4+=num;
                }
                if(birthyear>=1926&&birthyear<=1945){
                    sum5+=num;
                }
            }
            sum=sum1+sum2+sum3+sum4+sum5;
            rat1=(double)sum1/sum;
            rat2=(double)sum2/sum;
            rat3=(double)sum3/sum;
            rat4=(double)sum4/sum;
            rat5=(double)sum5/sum;
            DecimalFormat df1 = new DecimalFormat("0.00");
            String[] ageList={"18-35岁","36-45岁","46-55岁","56-70岁","71-90岁"};
            String[] ratList={df1.format(rat1*100),df1.format(rat2*100),df1.format(rat3*100),df1.format(rat4*100),df1.format(rat5*100)};
            List <MapData>dataList1=new ArrayList<MapData>();
            for(int i=0;i<5;i++){
                MapData nummap=new MapData(ageList[i],ratList[i]);
                dataList1.add(nummap);

            }
            data1.put(year, dataList1);
        }


        optionGroup.timeline()
                .autoPlay(true)
                .playInterval(1000)
                .setData(yearList);
        List<Option> options = new ArrayList<Option>();

        for (String year : yearList) {
            Option option = new Option();
            option.title().text("社保各年龄段参保人数占当年参保总人数百分比统计").subtext(year+"年度漏斗图分析");
            option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
            option.legend().data("18-35岁", "36-45岁", "46-55岁", "56-70岁", "71-90岁");
            option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
                    Tool.restore, Tool.saveAsImage);
            option.calculable(true);

            Funnel funnel = new Funnel();
            funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).label().show(true).position("inside");
            funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).labelLine().show(false).length(10).lineStyle().width(1).type(LineType.solid);
            funnel.itemStyle().emphasis().borderColor("red").borderWidth(1).label().show(true).formatter("{b}:{c}%").textStyle().fontSize(20);
            funnel.itemStyle().emphasis().borderColor("red").borderWidth(1).labelLine().show(true);

            funnel.name("各年龄段参保人数百分比（单位：%）").type(SeriesType.funnel)
                    .x("10%").y(60).y2(60).
                    width("80%")
                    .min(0).max(100).maxSize("100%").minSize("0%").gap(10)
                    .sort(Sort.descending).setData(data1.get(year));

            option.series(funnel);
            //add option
            options.add(option);

        }

        optionGroup.options(options);
        return optionGroup;

    }

    //支付统计option
    public GsonOption getChart05Option(String tittle) {
        GsonOption optionGroup = new GsonOption();

        List<FunnelChartPay> funnelList=getFunnelPayment(tittle);
        java.util.Map<String,List<MapData>> data=new HashMap<String, List<MapData>>();
        List<String> yearList=new ArrayList();

        String TEXT=getTittle(tittle);//获得对应标题

        for(FunnelChartPay funnelChart:funnelList){
            String year=String.valueOf(funnelChart.getYear());
            String birth=funnelChart.getBirth_year().trim();
            Integer per_payment=funnelChart.getPer_payment();
            List mapdataList=data.get(year);
            if(mapdataList==null){
                mapdataList=new ArrayList();
                data.put(year,mapdataList);
            }
            MapData mapData=new MapData(birth,per_payment);
            mapdataList.add(mapData);
            if(!yearList.contains(year)){
                yearList.add(year);
            }
        }

        java.util.Map<String,List<MapData>> data1=new HashMap<String, List<MapData>>();
        long sum=0,sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0;
        double rat1=0.0,rat2=0.0,rat3=0.0,rat4=0.0,rat5=0.0,rat6=0.0;

        for(String year:yearList){
            List <MapData>dataList=data.get(year);
            for(MapData list01:dataList){
                String birth=list01.getName();
                Integer num=(Integer)list01.getValue();
                int birthyear=Integer.valueOf(birth).intValue();
                if(birthyear>=1981 && birthyear<=1998){
                    sum1+=num;
                }
                if(birthyear>=1971&&birthyear<=1980){
                    sum2+=num;
                }
                if(birthyear>=1961&&birthyear<=1970){
                    sum3+=num;
                }
                if(birthyear>=1946&&birthyear<=1960){
                    sum4+=num;
                }
                if(birthyear>=1925&&birthyear<=1945){
                    sum5+=num;
                }
            }
            sum=sum1+sum2+sum3+sum4+sum5;
            rat1=(double)sum1/sum;
            rat2=(double)sum2/sum;
            rat3=(double)sum3/sum;
            rat4=(double)sum4/sum;
            rat5=(double)sum5/sum;
            DecimalFormat df1 = new DecimalFormat("0.00");
            String[] ageList={"18-35岁","36-45岁","46-55岁","56-70岁","71-90岁"};
            String[] ratList={df1.format(rat1*100),df1.format(rat2*100),df1.format(rat3*100),df1.format(rat4*100),df1.format(rat5*100)};
            List <MapData>dataList1=new ArrayList<MapData>();
            for(int i=0;i<5;i++){
                MapData nummap=new MapData(ageList[i],ratList[i]);
                dataList1.add(nummap);

            }
            data1.put(year, dataList1);
        }


        optionGroup.timeline()
                .autoPlay(true)
                .playInterval(1000)
                .setData(yearList);
        List<Option> options = new ArrayList<Option>();



        for (String year : yearList) {
            Option option = new Option();
            option.title().text("各年龄段参保人员"+TEXT+"待遇支付金额占当年参保待遇支付总金额百分比统计").subtext(year+"年度漏斗图分析");
            option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
            option.legend().data("18-35岁", "36-45岁", "46-55岁", "56-70岁", "71-90岁");
            option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
                    Tool.restore, Tool.saveAsImage);
            option.calculable(true);

            Funnel funnel = new Funnel();
            funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).label().show(true).position("inside");
            funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).labelLine().show(false).length(10).lineStyle().width(1).type(LineType.solid);
            funnel.itemStyle().emphasis().borderColor("red").borderWidth(1).label().show(true).formatter("{b}:{c}%").textStyle().fontSize(20);
            funnel.itemStyle().emphasis().borderColor("red").borderWidth(1).labelLine().show(true);

            funnel.name("参保人员待遇支付金额占当年参保待遇支付总金额百分比（单位：%）").type(SeriesType.funnel)
                    .x("10%").y(60).y2(60).
                    width("80%")
                    .min(0).max(100).maxSize("100%").minSize("0%").gap(10)
                    .sort(Sort.descending).setData(data1.get(year));

            option.series(funnel);
            //add option
            options.add(option);

        }

        optionGroup.options(options);
        return optionGroup;

    }


}
