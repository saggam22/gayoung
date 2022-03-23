package com.edu.api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(today));
		
		Date today2 = new Date("2022/01/01 00:00:00");
		today2.setYear(122); //1900년을 기준으로 값을 더해서 나타냄
		System.out.println(today2);
		
		LocalDateTime time = LocalDateTime.now(); //static메소드로 인스턴스를 만들어둬서 new인스턴스 생성 필요 x
		System.out.println(time.getYear() + "년");
		
	}
}
