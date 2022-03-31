package personal.project;

import java.sql.SQLException;
import java.util.*;

public class MemberServieQracle extends DAO implements MemberService {

	// 로그인 메소드
	public String logExecute(int memID, int password) {
		conn = getConn();
		String sql = "SELECT password FROM subject" + " WHERE member_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("password") == password) {
					return "로그인 성공";
				} else {
					return "비밀번호를 확인하세요";
				}
			}
			return "아이디를 확인하세요";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return "데이터 오류입니다.";
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
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement("SELECT * FROM member");
			rs = psmt.executeQuery();

			while (rs.next()) {
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
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement("SELECT * FROM member WHERE member_id = ?");
			psmt.setInt(1, memId);
			rs = psmt.executeQuery();
			if (rs.next()) {
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
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement("SELECT * FROM member WHERE member_name LIKE '%'||?||'%' ");
			psmt.setString(1, memName);
			rs = psmt.executeQuery();

			while (rs.next()) {
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

	// 회원정보 수정
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
} // end of class
