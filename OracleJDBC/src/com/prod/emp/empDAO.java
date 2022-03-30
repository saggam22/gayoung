package com.prod.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empDAO extends DAO {
	// 전체조회
	public List<Employee> empList() {

		conn = getConnect(); // DAO의 connetction을 쓰겠단 의미
		List<Employee> employees = new ArrayList<Employee>();
		try {
			psmt = conn.prepareStatement("select * from emp_java");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));

				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return employees;
	}

	// empId 한건조회
	public Employee getemp(int empId) {

		conn = getConnect();
		Employee emp = null; // 초기값으로 null을 지정해주면 EmpExe에서 if == null 조건을 달 수 있다
		try {
			String sql = "SELECT * FROM emp_java " + "WHERE employee_id = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}

	// 다중 조건 조회
	public List<Employee> getSalaryJob(int salary, String job_id) {

		conn = getConnect();
		List<Employee> saljobList = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM emp_java " 	
						+ "WHERE salary >= ? "
						+ "AND job_id LIKE '%'||?||'%' " //현업에서는 물을때 %넣어서 물어보질 않으니 쿼리문을 짤때 미리 넣어두면 검색이 편리하다 물음표를 넣으려면 fipe 값이 있어야함 자바에서 인식!!
						+ "ORDER BY employee_id ";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, salary);
			psmt.setString(2, job_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));

				saljobList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return saljobList;
	}
	
	// 다중 이름 조회
	public List<Employee> getNameList(String lastName) {

		conn = getConnect();
		List<Employee> nameList = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM emp_java " + "WHERE last_name LIKE ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lastName);
			rs = psmt.executeQuery(); 
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));

				nameList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return nameList;
	}

	// 입력처리
	public boolean insertUpdate(Employee emp) {
		conn = getConnect();
		String sql = "INSERT INTO emp_java (employee_id, last_name, email, hire_date, job_id) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());

			int r = psmt.executeUpdate(); // 조회할때는 executeQuery / 입력할때는 executeUpdate
			if (r > 0) {
				System.out.println(r + "건 입력되었습니다.");
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return false;
	}

	// 수정처리
	public void updateEmp(Employee emp) {
		conn = getConnect();
		String sql = "UPDATE emp_java "
				+ "SET first_name = ?, " 
				+ "    phone_number = ?, " 
				+ "    salary = ? "
				+ "WHERE employee_id = ? "; // 쿼리작성
		try {
			psmt = conn.prepareStatement(sql);
			// 파라메터(?) 값을 지정
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getPhoneNumber());
			psmt.setInt(3, emp.getSalary());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate(); // 실행
			System.out.println(r + "건 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제처리
	public void deleteUpdate(int empId) {
		conn = getConnect();
		String sql = "DELETE FROM emp_java " + "WHERE employee_id = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
