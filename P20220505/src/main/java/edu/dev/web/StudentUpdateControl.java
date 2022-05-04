package edu.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dev.dao.StudentDAO;
import edu.dev.service.StudentService;
import edu.dev.vo.StudentVO;

public class StudentUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String prof = request.getParameter("prof");
		
		if (num == 0 || name.isBlank() || dept.isBlank() || prof.isBlank()) {
			request.setAttribute("error", "항목을 모두 입력하세요");
			request.getRequestDispatcher("studentView/studentUpdate.jsp").forward(request, response);
		}
		
		StudentVO vo = new StudentVO();
		vo.setStudNo(num);
		vo.setStudName(name);
		vo.setDepartment(dept);
		vo.setProfessor(prof);
		
		StudentService dao = new StudentDAO();
		dao.updateStudent(vo);
		
		request.setAttribute("num", num);
		
		request.getRequestDispatcher("studentResult/studentUpdateOutput.jsp").forward(request, response);

	}

}
