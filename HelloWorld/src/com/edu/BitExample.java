package com.edu;

public class BitExample {
	public static void main(String[] args) {
		int num = 10;
		int result = num << 3;
		//비트연산자 >> 2 만큼 자리 이동을 한다. 1010 >> 10
		// 10 << 3 = 1010 << 1010000 
		System.out.println(result);
		
		int val = 100;
		val = val + 10;
		System.out.println(val); //110
		val += 20;
		System.out.println(val); //130
		
		val = val -5;  //125
		val -= 10; //115
		
		val = val * 2; //230
		val *= 2; //460
		System.out.println(val);
		
		String message = "반갑습니다.";
		System.out.println(message);
		
		message = message + "이가영입니다.";
		System.out.println(message);
		
		message += "좋은 하루 되세요!";
		System.out.println(message);
		
		int cnt = 0;
		cnt = cnt + 1;
		cnt += 1;
		cnt++; //3
		cnt--; //2
		System.out.println(cnt);
	}
}
