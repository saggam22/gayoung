package com.edu.thread;

import java.awt.Toolkit;

class BeepTask implements Runnable { // main 메소드 안에 tookit을 넣으면 순차적으로 소리가 난 후 beep문자가 출력되나
	// 클래스를 선언하고 main에 Thread를 생성하고 시작하면 소리와 동시에 beep문자가 나온다 (병렬처리)

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500); // 밀리세컨즈 단위 1s = 1000millis
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

} // end of BeepTask

//process(main thread)
public class BeepPrintExample {
	public static void main(String[] args) {

		// 스레드 생성하는 방법
		// 1) Tread 생성자의 매개값으로 Runnable을 구현한 객체 생성
//		Thread thread = new Thread(new BeepTask());

		// 2) BeepTask class를 따로 선언하지 않고 익명구현 생성해서 Thread클래스의 생성자 매개값으로 활용(메소드 생성 후
		// toolkit을 넣어줘도 된다)
//		Thread thread = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				for (int i = 0; i < 5; i++) {
//					toolkit.beep();
//					try {
//						Thread.sleep(500); // 밀리세컨즈 단위 1s = 1000millis
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//		});

		// 3) 람다식 표현(인터페이스 명과 메소드명을 알고 있다면..)
		Thread thread = new Thread(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500); // 밀리세컨즈 단위 1s = 1000millis
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		// 4) 스레드클래스를 상속받아서 사용가능 -> BeepTaskExample2 클래스 참고

		thread.start(); // 스레드 시작
		
		//beep 문구 출력
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
} // end of main
