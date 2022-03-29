package com.prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ojdbc 라이브러리, 오라클DB 연결(DB접속주소, hr, hr), Connection객체
//query실행(Statement, PreparedStatement)
public class JDBCSample {
//	DriverManager
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement psmt;

	public static Connection getConnect() {
		// DB연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결성공!!");
		return conn;
	}

	public static void disconnect() {
		try {
			if (rs != null) 
				rs.close();
			
			if (stmt != null) 
				stmt.close();
			
			if (conn != null) 
				conn.close();
			
			if (psmt != null)
				psmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		conn = getConnect();

		// Statement생성(쿼리를 실행하고 결과를 가져옴)
		try {
//			stmt = conn.createStatement();
			
			// 조회
//			rs = stmt.executeQuery("select * from emp_java");
//			while (rs.next()) { // 한건의 데이터를 가져옴
//				System.out.println("사원번호 : " + rs.getInt("employee_id"));
//				System.out.println("이름 : " + rs.getString("first_name"));
//			}

			// 입력
			int emp_id = 301;
//			String last_name = "홍길동";
//			String hire_date = "2020-03-05";
//			String email = "kilding@email.com";
//			String job = "IT_PROG";
//			String sql = "insert into emp_java(employee_id, last_name, email, hire_date, job_id) " + "values ("
//					+ emp_id + ", '" + last_name + " ', '" + email + " ', '" + hire_date + "', '" + job + "') ";
//			int r = stmt.executeUpdate(sql);
//			System.out.println(r + "건 입력되었습니다.");
			
			// 수정
			String fn = "길동입니다";
			String pn = "010-4321-7564";
			int salary = 8000;
			
//			String sql = "update emp_java \r\n"  // \r\n대신에 스페이스로 대체해도된다
//					+ "set first_name = '"+fn+"',\r\n"
//					+ "    phone_number = '"+pn+"',\r\n"
//					+ "    email = '" + email+"',\r\n"
//					+ "    salary = "+salary+"\r\n"
//					+ "where employee_id = "+emp_id+"";
//			int r = stmt.executeUpdate(sql);
//			System.out.println(r + "건 수정되었습니다.");
			
			//수정2
//			String sql = "update emp_java "
//					+ "set first_name = ?, "
//					+ "    phone_number = ?, "
//					+ "    salary = ? "
//					+ "where employee_id = ? ";
//			
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, fn);
//			psmt.setString(2, pn);
//			psmt.setInt(3, salary);
//			psmt.setInt(4, emp_id);
//			
//			int r = psmt.executeUpdate(); //이미 sql 쿼리문이 만들어졌기때문에 매개변수 없이 실행
//			System.out.println(r + "건 수정되었습니다.");
			
			//삭제
			String sql = "delete from emp_java "
					+ "where employee_id = ? ";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp_id);
			
			int r = psmt.executeUpdate(); //이미 sql 쿼리문이 만들어졌기때문에 매개변수 없이 실행
			System.out.println(r + "건 삭제되었습니다.");
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		disconnect();
	}
}
