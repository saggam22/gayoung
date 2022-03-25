package com.edu.thread;

import java.awt.Toolkit;

class BeepThread extends Thread {

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
} //end of Thread

public class BeepTaskExample2 {
	public static void main(String[] args) {
		
		//4) Thread 클래스를 상속받는 클래스를 선언. run메소드를 override기능 구현
		Thread thread = new BeepThread();
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("beep");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog");
	}
} //end of main
