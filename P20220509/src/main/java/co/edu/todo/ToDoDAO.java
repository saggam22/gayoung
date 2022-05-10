package co.edu.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//리스트
	public List<ToDoVO> getList() {
		String sql = "select * from mytodolist";
		getConnect();
		List<ToDoVO> list = new ArrayList<ToDoVO>();
		try {
			psmt = conn.prepareStatement(sql); // prepare객체를 만들기 위함
			rs = psmt.executeQuery();
			while (rs.next()) {
				ToDoVO vo = new ToDoVO(rs.getString("todo"));
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
	public void insertSchedule (ToDoVO vo) {
		String sql = " insert into mytodolist(todo) values(?)";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTodo());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	//수정
		public void updateSchedule (ToDoVO vo) {
			String sql = " update mytodolist set status=? where todo=?";
			
			getConnect();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getStatus());
				psmt.setString(2, vo.getTodo());
				int r = psmt.executeUpdate();
				System.out.println(r + "건 수정");
			} catch (SQLException e) {	
				e.printStackTrace();
			} finally {
				disConnect();
			}
			
		}
	
	//한건삭제
	public void deleteSchedule (String todo) {
		String sql = " delete from mytodolist where todo = ?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, todo);
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
