package com.test;

public class Book {
	
	private String bookName;
	private String writer;
	private String publisher;
	private int price;
	
	public Book(String bookName, String writer, String publisher, int price) { 
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	
	
	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}


	
	public String getBookInfo() {
		String str = "===================";
				str += "\n 책의 제목은 " + this.getBookName() + "이고, ";
				str += "\n 저자는 " + this.getWriter() + "이고,";
				str += "\n 출판사는 " + this.getPublisher() + "이고,";
				str += "\n 가격은 " + this.getPrice() + "입니다.";
				str += "\n===================\n";
				return str;
	}
}
