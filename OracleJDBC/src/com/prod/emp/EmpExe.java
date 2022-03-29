package com.prod.emp;

import java.util.List;

public class EmpExe {
	public static void main(String[] args) {
		empDAO dao = new empDAO();
		List<Employee> list = dao.empList(); //전체 조회기능
		
		for (Employee emp : list) {
			System.out.println(emp.toString());
		}
	}
}
