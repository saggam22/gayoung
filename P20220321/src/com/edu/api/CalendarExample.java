package com.edu.api;

import java.util.Calendar;

public class CalendarExample {
	public static void main(String[] args) {
		
		createCalendar(2022, 4);  //또는 int = year, month; 선언후  createCalendar(year, month)를 두고 선언부의 값을 바꿔도 된다
		                          //그럴 땐 메소드의 입력값의 변수를 다르게 설정해야한다. 예를 들어 int y,m;
		
	}
	
	public static void createCalendar (int year, int month) {
		
		Calendar today = Calendar.getInstance();
		//날짜 지정(무조건 시작날짜인 1을 입력해야 1일의 요일부터 시작되므로 캘린더 모양이 맞음)
		today.set(year, month-1, 1);
		System.out.println("올해는 : " + today.get(Calendar.YEAR)); //자바 자체에서 가지고 있는 메소드
		System.out.println("이번달은 : " + (today.get(Calendar.MONTH)+1)); //1월 : 0, 2월 : 1, 3월 : 2, ~~~
		System.out.println("오늘은 : " + today.get(Calendar.DATE));
		System.out.println("요일은 : " + today.get(Calendar.DAY_OF_WEEK)); // 일 : 1, 월 : 2, 화 : 3, ~~~~~
		System.out.println("마지막날의 정보 : " + today.getActualMaximum(Calendar.DATE));
		
		
		int gapDay = today.get(Calendar.DAY_OF_WEEK);
		int lastDate = today.getActualMaximum(Calendar.DATE);
		
		//요일 출력
		String[] days = {"SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT"};
		for(int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		//줄바꿈
		System.out.println();
		//1일 시작 칸 지정(공백 만들어주기)
		for (int i = 1; i < gapDay; i++) {
			System.out.printf("%4s", "");
		}
		//날짜 출력
		for(int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if((i + gapDay -1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n end of prog");
	}
}
