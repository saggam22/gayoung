package com.prod.emp;

public class Employee {
	// employees 테이블의 칼럼에 해당되는 필드설정
	private int employeeId;  //오라클의 employees.employee_id 와 자바 클래스 Employee와 헷갈리지 않도록 주의
	private String firstName;
	private String lastName;
	private String email;
	private int salary;
	private String hireDate;
	private String jobId;
	private String phoneNumber;
	
	public Employee() {
		super();
	}

	public Employee(int salary, String jobId) {
		super();
		this.salary = salary;
		this.jobId = jobId;
	}
	
	public Employee(int employeeId, String firstName, int salary, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}



	public Employee(int employeeId, String firstName, String lastName, String email, int salary, String hireDate,
			String jobId, String phoneNumber) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.phoneNumber = phoneNumber;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", salary=" + salary + ", hireDate=" + hireDate + ", jobId=" + jobId + "]";
	}
	
	
	
}
