package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet.do")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestServlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException { //실행되고 나서 최초 한번만 실행
		System.out.println("init() call.");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //최소 실행이 아닐 시 실행(새로고침 등)
		System.out.println("service() call.");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //출력스트림
		out.print("<h3>홍길동</h3>");
		out.print("<h3>네트워크정보</h3>");
		out.print("Request Scheme : " + request.getScheme() + "<br>");
		out.print("Server Name : " + request.getServerName() + "<br>");
		out.print("Request Address : " + request.getLocalAddr() + "<br>");
		out.print("Client Address : " + request.getRemoteAddr() + "<br>");
		out.print("Client Port : " + request.getRemotePort() + "<br>");
		
		out.print("<h3>요청 프로토콜</h3>");
		out.print("Request URI : " + request.getRequestURI() + "<br>");
		out.print("Request URL : " + request.getRequestURL() + "<br>");
		out.print("Context path : " + request.getContextPath() + "<br>");
		out.print("Request protocol : " + request.getProtocol() + "<br>");
		out.print("Server Path : " + request.getServletPath() + "<br>");
		
		out.print("queryString : " + request.getQueryString() + "<br>"); //초기 값은 null이다
		//http://localhost/P20220503/RequestServlet.do'?id=user1&passwd=1234&username=Hong' 주소창에 ''안의 내용을 치면 queryString : id=user1&passwd=1234&username=Hong 출력
		out.print("id : " + request.getParameter("id") + "<br>"); //파라메타 값을 가져올 수 있다
		out.print("passwd : " + request.getParameter("passwd") + "<br>");
		out.print("name : " + request.getParameter("username") + "<br>");
	}
}
