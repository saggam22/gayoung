package edu.dev.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	HashMap<String, Control> list = null;
	String charset = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Control>();
		list.put("/studentInsert.do", new StudentInsertControl());
		list.put("/studentList.do", new StudentListControl());
		list.put("/studentNameSearch.do", new StudentNameSearchControl());
		list.put("/studentNoSearch.do", new StudentNoSearchControl());
		list.put("/studentUpdate.do", new StudentUpdateControl());
		list.put("/studentDelete.do", new StudentDeleteControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		Control exeCon = list.get(path);
		exeCon.execute(req, resp);

	}
	
}
