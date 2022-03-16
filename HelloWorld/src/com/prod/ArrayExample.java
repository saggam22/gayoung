package com.prod;

public class ArrayExample {
	public static void main(String[] args) {
		// 1bit * 8 = 1byte / 1byte 는 -128 ~ -1, 0, 1~127 표현할수있음
//		int i1 = 100; // 4byte
//		byte b1 = 127; // 1byte
//		short s1 = 100; // -32768~-1, 0, 1~32767 / 4byte
//		long l1 = 123456543531L; //뒤에 L을 붙여서 long타입임을 알려준다 / 8byte
//		System.out.println(Integer.MAX_VALUE);
		
//		int score1 = 80;
//		int score2 = 90;
//		int score3 = 85;
//		int score4 = 95;
//		int score5 = 88;
		
//		int[] scores = new int[5];
//		
//		scores[0] = 80;
//		scores[1] = 90;
//		scores[2] = 85;
//		scores[3] = 95;
//		scores[4] = 88;
		
		int scores[] = {80, 90, 85, 95, 88, 90};
		
		System.out.println(scores[0] + scores[1]);
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			System.out.println(scores[i]);
			sum += scores[i];
		}
		double avg = sum / (double) 5;
		System.out.println(avg);
	}
}
