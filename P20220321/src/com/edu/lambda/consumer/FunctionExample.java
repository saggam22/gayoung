package com.edu.lambda.consumer;

import java.util.function.ToIntFunction;

import com.edu.collect.Student;

public class FunctionExample {
	public static void main(String[] args) {
		//Function 인터페이스 : 매핑작업 (Student -> int)
		
		//1)원래식
//		ToIntFunction<Student> func = new ToIntFunction<Student>() {
//
//			@Override
//			public int applyAsInt(Student value) {
//				return 0;
//			}
//		};
		
		//2)람다식
		ToIntFunction<Student> func = (student) -> student.getEngScore() + student.getKorScore();
		
		int result = func.applyAsInt(new Student(101, "Hong", 80, 90));
		System.out.println("결과값 : " + result);
	}
}
