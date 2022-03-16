package com.prod;

//클래스를 정의하는 부분
public class Calculator {
	
	double PI = 3.14;
	
	//매개변수, 매개변수
	int add(int n1, int n2) {
		return n1 + n2;
	}
	
	//반환 int, minus
	int minus(int v1, int v2) {
		return v1 - v2;
	}
	
	//사각형의 넓이 계산
	double getRecArea(double x, double y) {
		return x * y;
	}
	
	//원의 넓이 계산
	double getCircleArea(double radius) {
		return radius * radius *PI;
	}
}
