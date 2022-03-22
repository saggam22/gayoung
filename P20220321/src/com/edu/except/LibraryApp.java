package com.edu.except;

public class LibraryApp {
	public static void main(String[] args) {
//		LibraryExe exe = new LibraryExe(); //인스턴스를 선언하여야하지만 private걸려있어서 사용불가
		LibraryExe exe = LibraryExe.getInstance(); //새로운 메모리를 할당하지않고 하나만을 활용(singleton)
		exe.run();
	}
}
