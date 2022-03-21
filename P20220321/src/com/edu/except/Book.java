package com.edu.except;

public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("======================");
		System.out.println("책 제목은 " + this.title + "저자는 " + this.author + "가격은 " + this.price);
		System.out.println("======================");
	}
}
