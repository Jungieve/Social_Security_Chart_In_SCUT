package org.scut.mychart.model;

/**
 * @author gzw
 * 数据地图模型
 */
public class MapChartModel {
	private Double total_money;
    private Double average_money;
	private Integer  count_person;
    private Integer  year;
	private String   area;

    public Double getTotal_money() {
        return total_money;
    }

    public Double getAverage_money() {
        return average_money;
    }

    public Integer getCount_person() {
        return count_person;
    }

    public Integer getYear() {
        return year;
    }

    public String getArea() {
        return area;
    }

}
