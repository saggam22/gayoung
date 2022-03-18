package com.dev;

//2차원 배열
public class DimensionArray {
	public static void main(String[] args) {
		int[] intAray = {20, 38, 45};
		
		System.out.println(intAray[0]); // => 20
		
		int[][] intDimAry = { {23,34}, {12,32,45}, {37, 39} }; //[][]에서 순서대로 행과 열로 이해??
		
		int[] anotherAry = intDimAry[0]; // => int[]
		System.out.println(anotherAry[0] == intDimAry[0][0]); //둘 다 23을 가지므로 true
		
		System.out.println(intDimAry[0][1]); // => 34
		intDimAry[1][1] = 33;
		System.out.println(intDimAry[1][1]); //=> 33
		
		int[][] intRectAry = new int[5][5];
		int cntNum = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {	//총 25번 돌면서 배열
				intRectAry[i][j] = cntNum++;
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {	//총 25번 돌면서 배열
//				System.out.println("[" + i + "," + j + "] =>" + intRectAry[i][j]);
				System.out.printf("%3d", intRectAry[i][j]);
			}
			System.out.println();
		}
	}
}
