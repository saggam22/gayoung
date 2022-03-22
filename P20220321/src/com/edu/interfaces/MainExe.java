package com.edu.interfaces;

public class MainExe {
	public static void main(String[] args) {
		//리모콘 -> TV, radio, 냉장고
		RemoteControl rm = new TV();
		rm.powerOn();
		rm.powerOff();
		
		rm = new Radio();
		rm.powerOn();
		rm.powerOff();
		
		rm = new Refrigerator() ;
		rm.powerOn();
		rm.powerOff(); //같은 메소드지만 다른 결과가 나타나는 것 => 다형성
	}
}
