package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO {

	public void insertMember(MemberVO member) {
		conn = getConn();
		String sql = "INSERT INTO member2 VALUES(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getEmail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

	public void updateMember(MemberVO member) {
		conn = getConn();
		String sql = "UPDATE member2 SET name=?, passwd=?, email=? WHERE id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPasswd());
			psmt.setString(3, member.getEmail());
			psmt.setString(4, member.getId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

	public List<MemberVO> listMember() {
		conn = getConn();
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM member2 ORDER BY id ASC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setEmail(rs.getString("email"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return list;
	}
	
	public void deleteMember(String id) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("DELETE FROM member2 WHERE id=?");
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}
	
	public MemberVO searchMember(String id) {
		conn = getConn();
		MemberVO vo = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM member2 WHERE id=?");
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return vo;
	}
}
