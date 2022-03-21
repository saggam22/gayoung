package com.edu;

public class Person extends Object { //(extends Object)가 생략되어 있음
	//field 클래스에 값을 담아 넣기 위한 용도
	private String name;
	private int age;
	private double height;
	private double weight;
	
	//constructor 필드값을 초기화 하기 위한 용도
	public Person() {
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	//method 클래스에 기능을 넣기 위한 용도 / overloading (중복선언) 가능
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
