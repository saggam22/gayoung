package com.edu;

public class Student {
	//학생번호, 학생이름, 국어점수, 수학점수, 영어점수 <= 필드 정의
	private int studNo;
	private String studName;
	private int KorScore = -1; //값을 안넣었다는 의미의 -1 <= 점수가 0점일수있어서
	private int mathScore = -1;
	private int engScore = -1;
	
	//생성자: 필드의 값을 초기화..
	// public Student() {} 값이 없어도 오류가 나지 않음
	public Student() {
		this.studNo = 1;
		this.studName = "Nobody";
		this.KorScore = 0;
		this.engScore = 0;
	}
	
	public Student(int studNo) {
		this.studNo = studNo;
	}
	
	public Student(int studNo, String studName) {
		this.studNo = studNo;
		this.studName = studName;
	}
	
	//자동생성
	public Student(int studNo, String studName, int korScore, int mathScore, int engScore) {
		super();
		this.studNo = studNo;
		this.studName = studName;
		this.KorScore = korScore;
		this.mathScore = mathScore;
		this.engScore = engScore;
	}

	// 기능(method) => 규칙 : 반환값 메소드명 매개변수 { } 
	void setStudNo(int studNo) {
		this.studNo = studNo;
	}
	
	int getStudNo() {  //default는 생략가능 같은 패키지에서만 사용가능
		return this.studNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getKorScore() {
		return KorScore;
	}

	public void setKorScore(int korScore) {
		KorScore = korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
	
	//메소드..
	public static void callStatic() {
		System.out.println("정적메소드 실행...");
	}
	
	
	//영어, 국어, 수학 ==> 합계 점수
	
	int getSumScore() {
		if(this.KorScore != -1 && this.engScore != -1 && this.mathScore != -1) {
			return this.KorScore + this.engScore + this.mathScore;
		}
		return -1;
	}
	
	//영어, 국어, 수학 ==> 값이 저장되면 평균
	public double getAvgScore() {
		return this.getSumScore() / 3.0;
	}
	
	public String getStudInfo() {
		String str = "=====================";
		str += "\n 학생이름: " + this.getStudName() + "이고 "; // \n 줄바꿈 표시
		str += "\n 학번: " + this.getStudNo() + "이고 ";
		str += "\n 평균: " + String.format("%.2f", this.getAvgScore()) + "입니다.";
		str += "\n=====================\n";
		return str;
	}
}
