package org.scut.mychart.model;

public class Chart09 {

	private Integer  person_num;
    private String   job;
    private String   sex;
    private String   address;
    private String   title;
    private String   color;
    private String   work;
    private String   age;

	public Integer getperson_num() {
        return person_num;
    }
    public String  getjob() {
        return job;
    }
    public String  getsex() {
        return sex;
    }
    public String  getaddress() {
        return address;
    }
    public void   settitle(String t) {
        title=t;
    }
    public String  gettitle() {
        return title;
    }
    public void   setcolor(String c) {
        color=c;
    }
    public String  getcolor() {
        return color;
    }
    public String  getwork() {
        return work;
    }
    public String  getage() {
        return age;
    }
}
