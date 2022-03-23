package com.edu.api;

public class IDCheckExamlple {
	public static void main(String[] args) {
		
		IDCheck idcheck = new IDCheck();
		String result = idcheck.getGender("9503041234567");
		System.out.println(result);
		
		result = idcheck.getGender("950304-2234567");
		System.out.println(result);
		
		result = idcheck.getGender("9503041223456777");
		System.out.println(result);
		
		
		result = idcheck.getGender2("9503041234567");
		System.out.println(result);
		
		result = idcheck.getGender2("950304-2234567");
		System.out.println(result);
		
		result = idcheck.getGender2("9503041223456777");
		System.out.println(result);
		
		System.out.println("end of prog");
	}
}
