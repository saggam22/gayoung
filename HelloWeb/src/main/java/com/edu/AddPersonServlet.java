package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPersonServlet
 */
@WebServlet("/addPersonServlet")
public class AddPersonServlet extends HttpServlet { //HttpServlet : 주소를 넣어주면 http방식으로 화면을 구현해주는 자바 소스코드 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()); //프로젝트의 최상위 경로의 project를 보여줌
	} 
	//주소표시줄에 엔터를 주면 doGet메소드 실행 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//doGet(request, response);
		String id = request.getParameter("uid");
		String name = request.getParameter("uname");
		String score = request.getParameter("uscore");
		String age = request.getParameter("uage");
		
		System.out.println("아이디 : " + id);
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + score);
		System.out.println("나이 : " + age);
		//"form.html" -> 입력된 데이터 저장 버튼을 누르면 -> addPersonServlet으로 넘어가서 콘솔에 값이 나타남
		//즉 html 내용이 전환되어 java에서 구현
		//db insert/update/delete/select
		
		PrintWriter out = response.getWriter(); //InputStream, OutputStream 바이트단위 처리 / Reader, Writer 문자기반 처리
		out.println("<h3>응답결과</h3>");
		out.println("<h4>아이디 : " + id + "</h4>");
		out.println("<h4>이름 : " + name + "</h4>");
		out.println("<h4>점수 : " + score + "</h4>");
		out.println("<h4>나이 : " + age + "</h4>");
	}
	//form에 post를 넣으면 doPost 메소드 실행 

}
