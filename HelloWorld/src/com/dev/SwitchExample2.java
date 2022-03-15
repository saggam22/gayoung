package com.dev;

public class SwitchExample2 {
	public static void main(String[] args) {
		//90점 이상 a, 80점 이상 b, 70점 c, 60점 d, 그외 f
		
		int score = 75;
		
		switch (score/10) {
		case 10 :  //두개의 조건이 같을 경우 하나 생략 가능
		case 9 :
			System.out.println("A학점");
			break;
		case 8 :
			System.out.println("B학점");
			break;
		case 7 :
			System.out.println("C학점");
		    break;
		case 6 :
			System.out.println("D학점");
			break;
		default :
			System.out.println("F학점");
		}
	}
}
