package com.edu.api;

import java.lang.reflect.Method;

public class ClassExample {
	public static void main(String[] args) {
		//String, System, Member => 관리하는 class(class);
		
		Class cls = String.class;
		try {
		cls = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		Method[] methods = cls.getMethods();
		for (Method met : methods) { //들어가있는 건수 만큼만 반복하겠다
			System.out.println("메소드 이름 : " + met.getName());
		}
		
		cls = Member.class;
		
		String path = cls.getResource("ClassExample.class").getPath();
		System.out.println(path);
	}
}
