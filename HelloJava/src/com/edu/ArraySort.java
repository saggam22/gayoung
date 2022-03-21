package com.edu;

public class ArraySort {
	public static void sorting(int[] ary) { // ary는 변수이름이므로 내가 지정해서 넣으면 된다, static이 없으면 사용하려면 인스턴스를 만들어줘야함
		int loopCnt = ary.length - 1; // 마지막 값이 제일 처음 위치로 이동하려면 배열크기 -1
		for (int cnt = 0; cnt < loopCnt; cnt++) { // 최소값인 12가 처음 오기위한 for문 => 3번 옮겨야하므로
			int temp = ary[0]; // 초기화
			for (int i = 0; i < loopCnt; i++) { // 물잔 바꾸기(자리 바꾸기) 위한 for문 => 최소값인 12가 3번째 옴
				if (ary[i] > ary[i + 1]) {
					temp = ary[i];
					ary[i] = ary[i + 1];
					ary[i + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// 배열의 순서를 오름차순으로 정렬
		int[] intAry = { 34, 25, 48, 12 }; // 제일 마지막 값이 최소값이라고 가정
		int loopCnt = intAry.length - 1; // 마지막 값이 제일 처음 위치로 이동하려면 배열크기 -1
		for (int cnt = 0; cnt < loopCnt; cnt++) { // 최소값인 12가 처음 오기위한 for문 => 3번 옮겨야하므로
			int temp = intAry[0]; // 초기화
			for (int i = 0; i < loopCnt; i++) { // 물잔 바꾸기(자리 바꾸기) 위한 for문 => 최소값인 12가 3번째 옴
				if (intAry[i] > intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
		}

		int[] intAry2 = { 22, 56, 99, 12 };
		sorting(intAry2);  //메소드 사용
		for (int i = 0; i < intAry.length; i++) {
			System.out.print(intAry2[i] + "\t");
		}
	}
}
