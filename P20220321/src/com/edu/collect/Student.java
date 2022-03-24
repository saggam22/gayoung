package com.edu.collect;

public class Student {
	//학생번호(1, 2, 3), 이름(홍길동), 영어(80), 국어(70)
	private int number;
	private String name;
	private int engScore;
	private int korScore;
	
	
	//생성자 기본생성자, 매개값이 4개인 생성자
	public Student() {
		
	}
	
	public Student(int number, String name, int engScore, int korScore) {
		super();
		this.number = number;
		this.name = name;
		this.engScore = engScore;
		this.korScore = korScore;
	}

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	//toString() => 재정의
	@Override
	public String toString() {
		return "학생정보 [학생번호 = " + number + ", 이름 = " + name + ", 영어점수 = " + engScore + ", 국어점수 = " + korScore
				+ "]";
	}
}
