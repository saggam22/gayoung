package co.edu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class EmployeePerDept
 */
@WebServlet("/EmployeePerDept")
public class EmployeePerDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public EmployeePerDept() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;chartset=UTF-8");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "select e.department_id, d.department_name, count(1) as cnt from employees e, departments d\r\n"
				+ "where e.department_id = d.department_id\r\n"
				+ "group by e.department_id, d.department_name";
		
		try {
			psmt = conn.prepareStatement(sql); //prepare객체를 만들기 위함
			rs = psmt.executeQuery();
			Map<String, Integer> map = new HashMap<String, Integer>();
			while (rs.next()) {
				map.put(rs.getString("department_name"), rs.getInt("cnt"));
			}
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(map)); //toJson 생성
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// {"err":"에러 발생"}
		response.getWriter().print("{\"err\":\"에러 발생\"}");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
