package com.edu.io;

import java.io.FileReader;
import java.io.IOException;

public class ReadExample {
	public static void main(String[] args) {
		try {
			//문자기반 스트림(한문자씩) 입력스트림
			FileReader fr = new FileReader("second.txt");
			int readChar = -1;
			while ((readChar = fr.read()) != -1) {
				System.out.println((char) readChar); //강제형 변환 유니코드 값이 아니라 문자기반 형태로 나타내기 위함
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
