package edu.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dev.dao.StudentDAO;
import edu.dev.vo.StudentVO;

public class studentInsertControl implements Control {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String prof = request.getParameter("prof");
		
		StudentVO vo = new StudentVO();
		vo.setStudNo(num);
		vo.setStudName(name);
		vo.setDepartment(dept);
		vo.setProfessor(prof);
		
		StudentDAO dao = new StudentDAO();
		dao.insertStudent(vo);
		
	}
}
