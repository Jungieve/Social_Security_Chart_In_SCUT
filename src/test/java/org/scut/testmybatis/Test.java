package org.scut.testmybatis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance(); 
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		
		c.setTime(new Date("2015/12/31 00:00:00"));
		
		c.add(Calendar.YEAR, -22);
		
		System.out.println(1 + "2015");
	}
}
