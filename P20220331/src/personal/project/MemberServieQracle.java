package personal.project;

import java.sql.SQLException;
import java.util.*;

public class MemberServieQracle extends DAO implements MemberService {

	// 로그인 메소드
	public Member logExecute(int memID, int password) {
		conn = getConn();
		Member mem = null;
		String sql = "SELECT * FROM member WHERE member_id = ? AND password = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memID);
			psmt.setInt(2, password);
			rs = psmt.executeQuery();
			if (rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getInt("member_id"));
				mem.setPassword(rs.getInt("password"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPhone(rs.getString("member_phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return mem;
	}

	// 회원등록 메소드
	public void insetMember(Member mem) {
		conn = getConn();
		String sql = "INSERT INTO member (member_id, password, member_name, member_phone) VALUES (?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mem.getMemberId());
			psmt.setInt(2, mem.getPassword());
			psmt.setString(3, mem.getMemberName());
			psmt.setString(4, mem.getMemberPhone());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	} // end of insertMember method

	// 회원 전체 리스트
	public List<Member> memberList() {
		conn = getConn();
		List<Member> list = new ArrayList<Member>();
		Member mem = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM member ORDER BY member_id");
			rs = psmt.executeQuery();
			while (rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getInt("member_id"));
				mem.setPassword(rs.getInt("password"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPhone(rs.getString("member_phone"));

				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	} // end of memberList method

	// 회원 번호 검색
	public Member searchMember(int memId) {
		conn = getConn();
		Member mem = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM member WHERE member_id = ?");
			psmt.setInt(1, memId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getInt("member_id"));
				mem.setPassword(rs.getInt("password"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPhone(rs.getString("member_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return mem;
	}// end of serchMember method

	// 회원 이름 검색
	public List<Member> serchName(String memName) {
		conn = getConn();
		List<Member> list = new ArrayList<Member>();
		Member mem = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM member WHERE member_name LIKE '%'||?||'%' ");
			psmt.setString(1, memName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getInt("member_id"));
				mem.setPassword(rs.getInt("password"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPhone(rs.getString("member_phone"));

				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	}// end of serchName method

	// 회원정보 수정(관리자용)
	public void updateMember(Member mem) {
		conn = getConn();
		String sql = "UPDATE member SET password = ?, member_name = ?, member_phone = ? WHERE member_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mem.getPassword());
			psmt.setString(2, mem.getMemberName());
			psmt.setString(3, mem.getMemberPhone());
			psmt.setInt(4, mem.getMemberId());
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}// end of updateMember method
	
	// 회원정보 수정(회원용 정보만 변경)
		public void updateMyInfo(Member mem) {
			conn = getConn();
			String sql = "UPDATE member SET member_name = ?, member_phone = ? WHERE member_id = ? ";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(2, mem.getMemberName());
				psmt.setString(3, mem.getMemberPhone());
				psmt.setInt(4, mem.getMemberId());
				psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConn();
			}
		}
		
		// 회원정보 수정(회원용 비밀번호만 변경)
		public void updateMyPs(Member mem) {
			conn = getConn();
			String sql = "UPDATE member SET password = ? WHERE member_id = ? ";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, mem.getPassword());
				psmt.setInt(2, mem.getMemberId());
				psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConn();
			}
		}

	// 회원정보 삭제
	public void deleteMember(int memberId) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("DELETE FROM member WHERE member_id = ?");
			psmt.setInt(1, memberId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}// end of deleteMember method
	
	@Override
	public void insertExam(Exam exam) {
		conn = getConn();
		String sql = "INSERT INTO exam (exam_date, jumsu, result, member_id) VALUES (sysdate, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, exam.getJumsu());
			psmt.setString(2, exam.getResult());
			psmt.setInt(3, exam.getMemberId());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

	@Override
	public List<Exam> myExamList(Member mem) {
		conn = getConn();
		List<Exam> list = new ArrayList<Exam>();
		Exam exam = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM exam WHERE member_id = ? ORDER BY exam_date");
			psmt.setInt(1, mem.getMemberId());
			rs = psmt.executeQuery();

			while (rs.next()) {
				exam = new Exam();
				exam.setMemberId(rs.getInt("member_id"));
				exam.setExamDate(rs.getString("exam_date"));
				exam.setJumsu(rs.getInt("jumsu"));
				exam.setResult(rs.getString("result"));

				list.add(exam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	}

} // end of class
