package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	public List<BookVO> bookList() { //목록
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM book_info ORDER BY book_code";
		conn();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public BookVO selectBook(String bookCode) { //단건조회
		String sql = "SELECT * FROM book_info WHERE book_code=?";
		conn();
		BookVO vo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
			vo = new BookVO();
			vo.setBookCode(rs.getString("book_code"));
			vo.setBookTitle(rs.getString("book_title"));
			vo.setBookAuthor(rs.getString("book_author"));
			vo.setBookPress(rs.getString("book_press"));
			vo.setBookPrice(rs.getInt("book_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return vo;
	}

	public void insertBook(BookVO book) { //입력
		String sql = "INSERT INTO book_info VALUES (create_bookcode, ?, ?, ?, ?)";
		conn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	public void updateBook(BookVO book) { //수정
		String sql = "UPDATE book_info SET book_title=?, book_author=?, book_press=?, book_price=? WHERE book_code=?";
		conn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	public void deleteBook(String bookCode) { //삭제
		String sql = "DELETE FROM book_info WHERE book_code=?";
		conn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
}
