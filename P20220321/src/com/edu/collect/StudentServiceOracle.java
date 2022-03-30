package com.edu.collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService {

	@Override
	public void insertStudent(Student student) {
		conn = getConnect();
		String sql = "INSERT INTO student_info (student_no, studnet_name, eng_score, kor_score) "
				+ " VALUES (?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, student.getNumber());
			psmt.setString(2, student.getName());
			psmt.setInt(3, student.getEngScore());
			psmt.setInt(4, student.getKorScore());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public Student getStudent(int sno) {
		conn = getConnect();
		String sql = "SELECT * FROM student_info WHERE student_no = ? ";
		Student student = new Student();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				student.setNumber(rs.getInt("student_no"));
				student.setName(rs.getString("studnet_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return student;
	}

	@Override
	public List<Student> studentList() {
		List<Student> list = new ArrayList<Student>();
		conn = getConnect();
		String sql = "SELECT * FROM student_info ORDER BY student_no";
		try {
			psmt = conn.prepareStatement(sql); //인스턴스를 하나 새로 만들어줌(메소드를 활용할 매개변수로 sql문을 넣어둠)
			rs = psmt.executeQuery(); //실행
			while(rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getInt("student_no"));
				student.setName(rs.getString("studnet_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));
				
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void modifyStudent(Student sudent) {
		conn = getConnect();
		String sql = "UPDATE student_info "
				+ "SET eng_score = ?, "
				+ "      kor_score =  ?"
				+ "WHERE student_no = ?" ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sudent.getEngScore());
			psmt.setInt(2, sudent.getKorScore());
			psmt.setInt(3, sudent.getNumber());
			
			int r = psmt.executeUpdate(); // 실행
			System.out.println(r + "건 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void removeStudent(int sno) {
		conn = getConnect();
		String sql = "DELETE FROM student_info WHERE student_no = ? " ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);
	
			int r = psmt.executeUpdate(); // 실행
			System.out.println(r + "건 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}

	@Override
	public List<Student> searchStudent(String name) {
		List<Student> list = new ArrayList<Student>();
		conn = getConnect();
		String sql = "SELECT * FROM student_info WHERE studnet_name = ? ";
		try {
			psmt = conn.prepareStatement(sql); //인스턴스를 하나 새로 만들어줌(메소드를 활용할 매개변수로 sql문을 넣어둠)
			psmt.setString(1, name);
			rs = psmt.executeQuery(); //실행
			while(rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getInt("student_no"));
				student.setName(rs.getString("studnet_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));
				
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
		
	}

	@Override
	public void saveToFile() {

	}

}
