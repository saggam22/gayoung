package edu.dev.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllor extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	HashMap<String, Control> list = null;
	String charset = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter(charset);
		list = new HashMap<String, Control>();
		list.put("/studentInsert.do", new studentInsertControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		super.service(req, resp);
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		Control exeCon = list.get(path);
		exeCon.execute(req, resp);
	}

}
