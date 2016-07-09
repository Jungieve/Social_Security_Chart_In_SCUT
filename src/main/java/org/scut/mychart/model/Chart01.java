package org.scut.mychart.model;

public class Chart01 {
	
	private Double   total_payment;
	private Integer  person_num;
	private String   sex;
	private Integer  year;
	private Integer  month;
	//private String   the_month;
	
	public Double gettotal_payment() {
        return total_payment;
    }
	public Integer getperson_num() {
        return person_num;
    }
	public Integer getyear() {
        return year;
    }
	public Integer getmonth() {
        return month;
    }
//	public String getthe_month() {
//        return the_month;
//    }
	public String getsex() {
        return sex;
    }
}
