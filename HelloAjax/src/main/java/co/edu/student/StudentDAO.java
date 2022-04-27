package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {

	//전체조회
	public List<Student> studentList() {
		conn = getConn();
		List<Student> list = new ArrayList<Student>();
		try {
			Student s = null;
			psmt = conn.prepareStatement("select * from student_info");
			rs = psmt.executeQuery();
			while(rs.next()) {
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