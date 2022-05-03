package co.dev.web;

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
		list.put("/memberInsert.do", new MemberInsertControl());
		list.put("/memberUpdate.do", new MemberUpdateControl());
		list.put("/memberList.do", new MemberListControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8"); //하지 않고도 web.xml에 <init-param>설정 후 config.~으로 파라메터값을 들고옴
//		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding(charset);
		String url = req.getRequestURI(); //request.getRequestURI() 함수는 P20220503/memberInsert.do 을 가져옴 (프로젝트+파일명)
		String context = req.getContextPath(); //request.getContextPath()함수는 프로젝트 Path P50220503을 가져옴(프로젝트명)
		//request.getRequestURL() 함수는 전체 경로 http:// ~~
		//request.ServletPath() 함수는 memberInsert.do 또는 Update.do의 값을 가져옴(파일명)
		String path = url.substring(context.length()); //url에서 프로젝트의 길이부터 잘라냈으므로 memberInsert.do 또는 Update.do의 값을 가져옴(파일명)
		
		Control exeCon = list.get(path);
		exeCon.execute(req, resp);
	}
}
