package com.edu.interfaces;

public interface RemoteControl {
	//필드 불가 그러나 값이 변하지 않는 조건이라면 필드 선언가능 => 상수
//	private String maxVolum;
	public static final int MAX_VOLUME = 10; //static 인스턴스에 소속되있다 static 값이 변하지않는다 final
	public static final int MIN_VOLUME = 10; // 상수 선언시 대문자 사용
	//생성자 불가
	public void powerOn(); //기능없이 규칙만 정의 //구현하는 기능이 없는 추상메소드
	public void powerOff();
}
