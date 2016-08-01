package org.scut.mychart.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzw on 2016/7/15.
 */
public class DictionaryString {
    static public final String MAP="MAP";
    static public final String MAP_SUBMODE="MAP_SUBMODE";
    static public final String MAP_MARKPOINT="MAP_MARKPOINT";

    static public final String endowment="endowment";
    static public final String unemployment="unemployment";
    static public final String medical="medical";
    static public final String maternity="maternity";
    static public final String injury="injury";
    static public final String payment="payment";
    static public final String charges="charges";
    static public final String count="count";
    static public final String sum="sum";
    static public final String avg="avg";

    static public final String kaiping="开平市";
    static public final String enping="恩平市";
    static public final String taishan="台山市";
    static public final String heshan="鹤山市";
    static public final String xinhui="新会区";
    static public final String jianghai="江海区";
    static public final String pengjiang="蓬江区";
    static public double[] kaipingpoint={112.592262,22.450247};
    static public double[] enpingpoint={112.314051,22.250713};
    static public double[] taishanpoint={112.793414,22.052956};
    static public double[] heshanpoint={112.793414,22.638104};
    static public double[] xinhuipoint={113.038584,22.366286};
    static public double[] jianghaipoint={113.120601,22.560211};
    static public double[] pengjiangpoint={113.07859,22.65677};
    static public String getStringChinese(String string){
        if(string.equals(endowment)) {
            return "养老保险";
        }else if(string.equals(unemployment)){
            return "失业保险";
        }else if(string.equals(medical)){
            return "医疗保险";
        }else if(string.equals(injury)){
            return "工伤保险";
        }else if(string.equals(maternity)) {
            return "生育保险";
        }else if(string.equals(payment)){
            return "支付";
        }else if(string.equals(charges)) {
            return  "缴费";
        }else{
            return "";
        }
    }
    static public double[] getGeoCoord(String area){

        if(area.equals(kaiping)){
            return kaipingpoint;
        }else if (area.equals(enping)){
            return  enpingpoint;
        }else if (area.equals(taishan)){
            return  taishanpoint;
        }else if (area.equals(heshan)){
            return  heshanpoint;
        }else if (area.equals(xinhui)){
            return  xinhuipoint;
        }else if (area.equals(jianghai)){
            return  jianghaipoint;
        }else if (area.equals(pengjiang)){
            return  pengjiangpoint;
        }
        return null ;

    }
}
