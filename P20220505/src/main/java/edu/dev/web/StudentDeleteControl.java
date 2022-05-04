package edu.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dev.dao.StudentDAO;
import edu.dev.service.StudentService;
import edu.dev.vo.StudentVO;

public class StudentDeleteControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		
		StudentService dao = new StudentDAO();
		dao.delStudent(num);
		
		request.setAttribute("num", num);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("studentResult/studentDeleteOutput.jsp").forward(request, response);

	}

}
