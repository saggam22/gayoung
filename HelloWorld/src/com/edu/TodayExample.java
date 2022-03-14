package com.edu;

import java.util.Scanner;

//이름을 입력받도록 (String)
//연락처 입력받기 (String)
//나이 입력받기 (int)
//키 입력 (double)
//적정몸무게 : (키-100)*0.9
public class TodayExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String name, phone;
		int age;
		double tall, weight, realweight;
		
		System.out.println("이름을 입력하세요");
		name = scn.nextLine();
		System.out.println("연락처를 입력하세요");
		phone = scn.nextLine();
		System.out.println("나이를 입력하세요");
		age = scn.nextInt();
		System.out.println("키를 입력하세요");
		tall = scn.nextDouble();
		System.out.println("몸무게를 입력하세요");
		realweight = scn.nextDouble();
		
		System.out.println("이름은 :" + name);
		System.out.println("연락처 :" + phone);
		System.out.println("나이 :" + age);
		System.out.println("키 :" + tall);
		System.out.println("몸무게 :" + realweight);
		
		weight = (tall - 100)*0.9;
				
		if (weight + 5 > realweight && weight - 5 < realweight) {
			System.out.println("적정몸무게입니다.");
		} else {
			System.out.println("비정상입니다.");
		}
		scn.close();
	}
}
