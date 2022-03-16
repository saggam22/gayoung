package com.prod;

public class BookExample {
	public static void main(String[] args) {
		// 책 제목, 저자, 출판사, 가격

		Book b1 = new Book();
		b1.bookName = "혼공자";
		b1.bookWriter = "신용권";
		b1.company = "한빛미디어";
		b1.price = 24000;

		Book b2 = new Book();
		b2.bookName = "파워자바";
		b2.bookWriter = "천인국";
		b2.company = "인피니티";
		b2.price = 35000;

		Book b3 = new Book();
		b3.bookName = "재밌는 자바";
		b3.bookWriter = "이호준";
		b3.company = "인피니티";
		b3.price = 20000;

		Book[] books = { b1, b2, b3 };

		for (int i = 0; i < books.length; i++) {
			if (books[i].company == "인피니티") {
				System.out.println(books[i].bookName);
				System.out.println(books[i].bookWriter);
				System.out.println(books[i].price);
				System.out.println("===================");
			}
		}
		for (int i = 0; i < books.length; i++) {
			if (books[i].bookWriter == "신용권") {
				System.out.println(books[i].bookName);
				System.out.println("===================");
			}
		}
	}
}
