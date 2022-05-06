package edu.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dev.dao.StudentDAO;
import edu.dev.service.StudentService;
import edu.dev.vo.StudentVO;

public class StudentNoSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("num"));
		String cmd = request.getParameter("cmd");
		
		String path="";
		if (cmd.equals("search")) {
			path = "studentView/studentNoSearch.jsp";
		} else if (cmd.equals("update")) {
			path = "studentView/studentUpdate.jsp";
		} else if (cmd.equals("delete")) {
			path = "studentView/studentDelete.jsp";
		}
		
		if (no == 0) {
			request.setAttribute("error", "검색할 학번을 입력하세요");
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		
		StudentService dao = new StudentDAO();
		StudentVO student = dao.searchNo(no);
		
		if (student == null) {
			request.setAttribute("result", "조회된 학생이 없습니다.");
		}
		
		request.setAttribute("student", student);
		
		if (cmd.equals("search")) {
			path = "studentResult/noSearchOutput.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
