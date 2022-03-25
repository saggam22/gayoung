package com.edu.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edu.collect.Student;

public class StudentFileExample {
	
	static Scanner scn = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
//		writeStudent();
		readStudent();  //텍스트 101 이용용 100 100 => new Student(101,이용용,100,100)
		
		for(Student student : list) {
			System.out.println(student.toString());
		}
		
		System.out.println("end of prog");
	} // end of main
	
	//Student.txt 읽어들이는 메소드
	public static void readStudent() {
		try {
			FileReader fr = new FileReader("Student.txt");
			BufferedReader br = new BufferedReader(fr);
			String readStr = null;
			
			while((readStr = br.readLine()) != null) { //br.readLine() 한 라인을 읽어옴
				String[] contents = readStr.split(" "); //읽어들인 문자열에서 공란을 기준으로 자르고 문자열을 배열에 담아줌
				list.add(new Student(Integer.parseInt(contents[0]), contents[1], Integer.parseInt(contents[2]), Integer.parseInt(contents[3]))); //Integer.parseInt 해주는 이유 : String(문자)이므로 int타입으로 바꿔줌
				
//				System.out.println(readStr);
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Student.txt 쓰는 메소드
	public static void writeStudent() {
		
		try {
			FileWriter fw = new FileWriter("Student.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			while (true) {
				System.out.println("정보를 입력>> 학생번호 이름 점수1 점수2");
				String name = scn.nextLine();  //한 문장 전체를 읽어들임
				if (name.equals("stop")) {
					break;
				}
				bw.write(name + "\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
