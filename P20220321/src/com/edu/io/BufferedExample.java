package com.edu.io;

import java.io.*;

public class BufferedExample {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("C:/temp/image.jpg");
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/temp/copy3.jpg"));) {  //try 조건안에 넣어주면 따로 변수.close를 해주지 않아도 된다

			int readByte = -1;

			while ((readByte = bis.read()) != -1) {  //보조스트림을 사용하면 배열선언없이 입출력 능력 향상
				bos.write(readByte);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
