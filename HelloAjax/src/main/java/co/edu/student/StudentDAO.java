package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {
	
	//한건 수정
		public boolean modifyStudent(Student std) {
			conn = getConn();
			try {
				psmt = conn.prepareStatement("UPDATE student_info SET studnet_name=?, eng_score=?, kor_score=? WHERE student_no=?");
				psmt.setString(1, std.getStudentName());
				psmt.setInt(2, std.getEngScore());
				psmt.setInt(3, std.getKorScore());
				psmt.setInt(4, std.getStudentNo());
				
				int r = psmt.executeUpdate();
				System.out.println(r + "건 삭제");
				if (r > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConn();
			}
			return false;
		}
	
	//한건 삭제
	public boolean removeStudent(String id) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("DELETE FROM student_info WHERE student_no=?");
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 한건입력
	public boolean addStudent(Student stud) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("INSERT INTO student_info VALUES(?, ?, ?, ?)");
			psmt.setInt(1, stud.getStudentNo());
			psmt.setString(2, stud.getStudentName());
			psmt.setInt(3, stud.getEngScore());
			psmt.setInt(4, stud.getKorScore());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 전체조회
	public List<Student> studentList() {
		conn = getConn();
		List<Student> list = new ArrayList<Student>();
		try {
			Student s = null;
			psmt = conn.prepareStatement("select * from student_info order by student_no ASC");
			rs = psmt.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setStudentNo(rs.getInt("student_no"));
				s.setStudentName(rs.getString("studnet_name"));
				s.setEngScore(rs.getInt("eng_score"));
				s.setKorScore(rs.getInt("kor_score"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	}
}