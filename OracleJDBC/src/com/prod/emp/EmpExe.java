package com.prod.emp;

import java.util.List;
import java.util.Scanner;

public class EmpExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		empDAO dao = new empDAO();

		// 메뉴 : 1.사원리스트 2.입력 3.수정 4.삭제 5.한건조회(직원번호) 6.조회(직원성) 9.종료
		while (true) {
			System.out.println("1.사원리스트 2.입력 3.수정 4.삭제 5.한건조회(직원번호) 6.직원조회(직원의 last name) 7.다중조건 조회 9.종료");
			System.out.println("메뉴선택 >> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				
				List<Employee> list = dao.empList(); // 전체 조회기능
				
				System.out.println("사원리스트");
				for (Employee emp : list) {
					System.out.println(emp.toString());
				}
	
			} else if (menu == 2) {
				System.out.println("직원번호를 입력하세요");
				int empId = scn.nextInt();
				System.out.println("성을 입력하세요");
				String lastName = scn.next();
				System.out.println("이메일을 입력하세요");
				String email = scn.next();
				System.out.println("입사일을 입력하세요");
				String hireDate = scn.next();
				System.out.println("하는일을 입력하세요");
				String jobId = scn.next();
				
//				Employee em = new Employee(empId, null, lastName, email, 0, hireDate, jobId, null); //전체 생성자 생성
				
				Employee em = new Employee(); //기본생성자에 set메소드로 값 입력
				em.setEmployeeId(empId);
				em.setLastName(lastName);
				em.setEmail(email);
				em.setHireDate(hireDate);
				em.setJobId(jobId);
				
				//불린타입으로 결과값 확인
				boolean tOrF = dao.insertUpdate(em);
				if (tOrF) {
					System.out.println("정상처리 되었습니다.");
				} else {
					System.out.println("오류발생");
				}
			
			} else if (menu == 3) {
				System.out.println("직원번호를 입력하세요");
				int empId = scn.nextInt();
				System.out.println("이름을 입력하세요");
				String firstName = scn.next();
				System.out.println("핸드폰번호를 입력하세요");
				String phone = scn.next();
				System.out.println("연봉를 입력하세요");
				int salary = scn.nextInt();
				
				Employee em = new Employee(empId, firstName, salary, phone); //부분생성자 생성
				dao.updateEmp(em);
				
			} else if (menu == 4) {
				System.out.println("삭제할 직원번호를 입력하세요");
				int empId = scn.nextInt();
				dao.deleteUpdate(empId);
				
			} else if (menu == 5) {
				System.out.println("조회할 직원번호를 입력하세요");
				int empId = scn.nextInt();
				if (dao.getemp(empId) == null) {
					System.out.println("조회 결과가 없습니다.");
				} else {
					System.out.println(dao.getemp(empId).toString());
				}
				
			} else if (menu == 6) {
				System.out.println("조회할 직원성을 입력하세요");
				String lastName = scn.next();
				List<Employee> list = dao.getNameList(lastName); 
				
				if (list.size() != 0) {
					System.out.println(lastName + "씨 성을 가진 사원리스트");
					for (Employee emp : list) {
						System.out.println(emp.toString());	
				} 
				}else if (list.size() == 0) {
					System.out.println("해당되는 직원이 없습니다.");
				}
				
			} else if (menu == 7) {
				System.out.println("연봉을 입력하세요");
				int salary = scn.nextInt();
				System.out.println("job_Id를 입력하세요");
				String jobId = scn.next();
				List<Employee> list = dao.getSalaryJob(salary, jobId);
				
				System.out.println(salary + "이상이고 " + jobId + "성을 가진 사원리스트");
				for (Employee emp : list) {
					System.out.println(emp.toString());	
				} 
				
			} else if (menu == 9) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		} //end of while
		System.out.println("end of program");
		scn.close();
	} // end of main
}
