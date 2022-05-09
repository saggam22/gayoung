package co.edu.full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//리스트
	public List<FullVO> getList() {
		String sql = "select * from full_calendar";
		getConnect();
		List<FullVO> list = new ArrayList();
		try {
			psmt = conn.prepareStatement(sql); // prepare객체를 만들기 위함
			rs = psmt.executeQuery();
			while (rs.next()) {
				FullVO vo = new FullVO(rs.getString("title"), rs.getString("start_date"), rs.getString("end_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	//한건입력
	public void insertSchedule (FullVO vo) {
		String sql = " insert into full_calendar (title, start_date, end_date)\r\n"
				+ " values (?,?,?)";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	//한건삭제
	public void deleteSchedule (String title) {
		String sql = " delete from full_calendar where title = ?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void getConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disConnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
