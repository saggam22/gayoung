package edu.dev.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dev.dao.StudentDAO;
import edu.dev.service.StudentService;
import edu.dev.vo.StudentVO;

public class StudentListControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentService dao = new StudentDAO();
		List<StudentVO> list = dao.studentList();
		
		
		request.setAttribute("result", list);
		request.getRequestDispatcher("studentResult/studentListOutput.jsp").forward(request, response);
		
	}

}
