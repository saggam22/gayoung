package co.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Info extends HttpServlet { //자바에서 기본으로 제공해주는 클래스

	//Info 페이지 요청 -> Init() -> Service() -> Destroy() 의 생명주기를 가진다
	//제일 처음 페이지가 실행 될때만 Init을 통해서 실행되고 그 뒤부터는 Service()를 새로고침
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                                         //요청정보, 응답정보
		
		resp.setCharacterEncoding("UTF-8"); //응답을 보내는 페이지에 UTF-8로
		resp.setContentType("text/html;charset=UTF-8"); //만드는 페이지에 UTF-8로
		
		//출력
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>서블릿 페이지</h3>");
		out.print("<h3>안녕하세요</h3>");
		out.print("<a href=\"../index.html\">index</a>");
		// \를 쓰는 이유는 "를 문자로 인식해야하므로 작성
	}
}
