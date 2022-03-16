package com.prod; //get, set 메소드는 7-80% 사용되어지니 개념 및 활용법 잘 이해!!

public class Employee {
	// field
	private int employeeId;
	private String employeeName;
	private String department;
	private String job;
	private int salary; // private 선언시 다른 클래스에서 사용x
	
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId; // 필드값과 매개변수 이름이 같을 경우 this로 필드명을 구분
	}

	public int getEmployeeId() {
		return this.employeeId;
	}
	
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	
	public void setjob(String job) {
		this.job = job;
	}
	
	public String getjob() {
		return this.job;
	}
	
	
	public void setSalary(int salary) { 
		if (salary < 0) {
			this.salary = 1000000;
		} else {
			this.salary = salary; // 정상적인 처리를 해주기 위해 메소드 설정
		}
	}

	public int getSalary() {
		return this.salary;
	}
	
	
	public String getEmpInfo() {
		String result = this.employeeName + "의 부서는 " + this.department + "이고 직무는 "
				+ this.job + "이고 급여는 " + this.salary + "입니다.";
		return result;
	}
}
