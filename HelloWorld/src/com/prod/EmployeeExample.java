package com.prod;

public class EmployeeExample {
	public static void main(String[] args) {
		
		Employee e1 = new Employee(); //필드 초기화
		
//		e1.employeeId = 100;
		e1.setEmployeeId(100);
		
//		e1.employeeName = "김사원";
		e1.setEmployeeName("김사원");
		
//		e1.department = "개발부";
		e1.setDepartment("개발부");
		
//		e1.job = "월급계산";
		e1.setjob("월급계산");
		
//		e1.salary = 1000000;  //private 선언을 해서 외부클래스에서 활용을 못함
		e1.setSalary(-1000000);
		System.out.println(e1.getSalary());
		
		System.out.println(e1.getEmployeeName() + "의 부서는 " + e1.getDepartment() + "이고 "
				+ "직무는 " + e1.getjob() + "이고 급여는 " + e1.getSalary() + "입니다.");
		
		System.out.println(e1.getEmpInfo());  //메소드로 기능 구현을 해놨으니 생성자를 추가할때마다 길게 작성할 필요 없음
	
		Employee e2 = new Employee();
		e2.setEmployeeId(101);
		e2.setEmployeeName("이영짱");
		e2.setDepartment("총무부");
		e2.setjob("비품구매");
		e2.setSalary(2000000);
		
		System.out.println(e2.getEmpInfo());
		
	}
}
