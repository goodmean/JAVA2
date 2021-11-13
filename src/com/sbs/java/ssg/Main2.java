package com.sbs.java.ssg;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2 {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date time = new Date();
		
		String time1 = format.format(time);
		
		System.out.println(time1);
		
	}
}
