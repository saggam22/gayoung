package com.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutExample {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/image.jpg");
			FileOutputStream fos = new FileOutputStream("C:/temp/copy2.jpg");
			
			int readByte = -1;
			byte[] readBytes = new byte[100];
			while ((readByte = fis.read(readBytes)) != -1) {
//				fos.write(readBytes); //byte배열 읽어들인만큼 byte로 쓰겠다 => byte값을 하나씩 정수 값으로 읽어들이고 반환하는 것보다 것보다 byte[100]가 찰때까지 읽어들이고 쓸때도 한번에 쓰겠다 => 입출력 시간이 줄어듬 
				fos.write(readBytes, 0, readByte); // 배열, 시작점, 사용할 바이트 (ex.170 바이트를 읽을때 100바이트를 읽고 또 100바이트를 읽지않고 필요한 바이트(70바이트) 만큼을 읽어들인다)
			}
			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
