package com.dev;

public class Singleton {
		private static Singleton instance = new Singleton(); 
		
		private Singleton() { //생성자를 private로 막음	
		}
		
		public static Singleton getInstance() { //
			return instance;
		}
}
