package com.dev;

public class GugudanEx {

	public static void printGugudan() {
//		System.out.println("2 * 1 = 2");

//		for (int i = 2; i <= 9; i++) {
//			System.out.println(i + "단 입니다.");
//			for (int j = 1; j <= 9; j++) {
//				System.out.println(i + " * " + j + " = " + (i * j));
//			}
//		}

		// 내가 만든 구구단 (정렬)
		for (int n = 2; n <= 9; n++) {
			System.out.print("[" + n + "단]         ");
		}
		for (int i = 1; i <= 9; i++) {
			System.out.println("");
			for (int j = 2; j <= 9; j++) {
//				System.out.print(j + " * " + i + " = " + (i * j) + "    ");
				System.out.printf("%2d * %2d = %2d", j, i, (i * j));
			}
		}

		// 교슈님이 만든 구구단 (정렬)
		for (int j = 1; j <= 9; j++) {
			for (int i = 2; i <= 9; i++) {
				System.out.printf("%2d * %2d = %2d", i, j, (i * j));
			}
			System.out.println();
		}
	} // end of printGugudan()
	
	public static void printStar(int runCnt, String shape) {
		for(int i = 0; i < runCnt; i++) {
		System.out.print(shape);
		}
	}
	
	public static void gugudan(int dan) {
		System.out.println("[" + dan + "단]");
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
	}

	public static int sum(int n1, int n2) {
		return n1 + n2;
	}
	
	//나누기 메소드(int, int) 반환은 더블타입, 나누는 값이 0이면 0리턴
	public static double divide(int d1, int d2) {
		if (d2 == 0) {
			return 0;
		}
		return d1 / (double) d2;
	}
	
	public static int sum(int[] ary) {
		//배열 매개변수의 각 요소의 합을 구하는 메소드
		int sum = 0;
		for (int i=0; i<ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}
	
	public static void main(String[] args) { // new로 초기화하지 않나도 메모리를 읽어들이는 시점에 초기화되어 실행가능
		// main이라는 메소드는 클래스가 시작할때 메인 메소드가 실행되는 메소드
		// 메소드 실행하려면 new 클래스 이름(); ex.Student s1 = new Student();

//		Student.callStatic(); //인스턴스를 만들지 않아도 메소드 실행 = static
		
//		printGugudan(); //메소드 실행
		
//		for (int i = 1; i <= 5; i++) {
//			printStar(i, "★");
//			System.out.println();
//		}
		
//		gugudan(5);
		
		int result = sum(sum(10, 20), sum(5, 7));
		System.out.println("결과는 " + result);
		
//		System.out.println(divide(10, 4));
		
		int[] newAry = {10, 20, 30};
		result = sum(newAry);
		System.out.println("결과는 " + result);
		
	} // end of main()
}
