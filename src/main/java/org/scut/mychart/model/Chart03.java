package org.scut.mychart.model;

public class Chart03 {
	private Double   total_charges;
	private Integer  person_num;
	private String   sex;
	private String   occupation;
	private Integer  year;
//	private Integer  month;

	
	public Double gettotal_charges() {
        return total_charges;
    }
	public Integer getperson_num() {
        return person_num;
    }
	public Integer getyear() {
        return year;
    }
//	public Integer getmonth() {
//        return month;
//    }
	public String getoccupation() {
        return occupation;
    }
	public String getsex() {
        return sex;
    }
}
