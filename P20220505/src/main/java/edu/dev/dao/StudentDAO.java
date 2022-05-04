package edu.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dev.DAO;
import edu.dev.service.StudentService;
import edu.dev.vo.StudentVO;

public class StudentDAO extends DAO implements StudentService{

	//전체 조회
	@Override
	public List<StudentVO> studentList() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		StudentVO student = null;
		conn = getConn();
		try {
			psmt = conn.prepareStatement("SELECT * FROM student_test ORDER BY stud_no ASC");
			rs = psmt.executeQuery();
			while (rs.next()) {
				student = new StudentVO();
				student.setStudNo(rs.getInt("stud_no"));
				student.setStudName(rs.getString("stud_name"));
				student.setDepartment(rs.getString("department"));
				student.setProfessor(rs.getString("professor"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	}

	//학생 검색
	@Override
	public List<StudentVO> searchName(String name) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		StudentVO student = null;
		conn = getConn();
		try {
			psmt = conn.prepareStatement("SELECT * FROM student_test WHERE stud_name LIKE '%'||?||'%' ORDER BY stud_no ASC");
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while (rs.next()) {
				student = new StudentVO();
				student.setStudNo(rs.getInt("stud_no"));
				student.setStudName(rs.getString("stud_name"));
				student.setDepartment(rs.getString("department"));
				student.setProfessor(rs.getString("professor"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	}
	
	//학번 검색
	@Override
	public StudentVO searchNo(int number) {
		StudentVO student = null;
		conn = getConn();
		try {
			psmt = conn.prepareStatement("SELECT * FROM student_test WHERE stud_no=?");
			psmt.setInt(1, number);
			rs = psmt.executeQuery();
			while (rs.next()) {
				student = new StudentVO();
				student.setStudNo(rs.getInt("stud_no"));
				student.setStudName(rs.getString("stud_name"));
				student.setDepartment(rs.getString("department"));
				student.setProfessor(rs.getString("professor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return student;
	}


	//학생 삭제
	@Override
	public void delStudent(int number) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("DELETE FROM student_test WHERE stud_no=?");
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}	
	}

	
	//학생 정보 수정
	@Override
	public void updateStudent(StudentVO student) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("UPDATE student_test SET stud_name=?, department=?, professor=? WHERE stud_no=?");
			psmt.setString(1, student.getStudName());
			psmt.setString(2, student.getDepartment());
			psmt.setString(3, student.getProfessor());
			psmt.setInt(4, student.getStudNo());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}	
	}

	//학생 정보 입력
	@Override
	public void insertStudent(StudentVO student) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("INSERT INTO student_test VALUES(?, ?, ?, ?)");
			psmt.setInt(1, student.getStudNo());
			psmt.setString(2, student.getStudName());
			psmt.setString(3, student.getDepartment());
			psmt.setString(4, student.getProfessor());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}	
	}
	
}
