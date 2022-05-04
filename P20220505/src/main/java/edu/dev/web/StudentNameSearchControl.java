package edu.dev.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dev.dao.StudentDAO;
import edu.dev.service.StudentService;
import edu.dev.vo.StudentVO;

public class StudentNameSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		if (name.isEmpty()) {
			request.setAttribute("error", "검색할 학생의 이름을 입력하세요");
			request.getRequestDispatcher("studentView/studentNameSearch.jsp").forward(request, response);
			
		} else {
			StudentService dao = new StudentDAO();
			List<StudentVO> list = dao.searchName(name);
			
			request.setAttribute("result", list);
			request.getRequestDispatcher("studentResult/nameSearchOutput.jsp").forward(request, response);
		}
		
	}

}
