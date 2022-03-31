package personal.project;

import java.sql.SQLException;

public class MemberExe extends DAO {

	// 로그인 메소드
	public String logExecute(int memID, int password) {
		conn = getConn();
		String sql = "SELECT * FROM subject"
				+ " WHERE member_id = ?" ;
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
}
