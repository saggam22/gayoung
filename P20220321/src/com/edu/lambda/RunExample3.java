package com.edu.lambda;

interface Runnable3 {
	public int run(String str); //매개변수 있고
}

public class RunExample3 {
	public static void main(String[] args) {
		Runnable3 runnable = (String str) -> {
			return str.length(); //반환타입이 있을 경우
		};
		int lnth = runnable.run("Hello, World");
		System.out.println(lnth);
	}
}
