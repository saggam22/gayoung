package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// IOC : Introversion if control
public class StudentServlet extends HttpServlet {
	@Override
	public void init() throws ServletException { //서블릿이 첫 번째 실행될 때 한 번 실행
		System.out.println("init() 호출");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String method = req.getMethod();
		PrintWriter out = resp.getWriter(); //출력스트림 생성(파일이면 파일로 생성, 웹이면 웹으로 생성)
		out.print("<h3>Student Sample page.</h3>");

		if(method.equals("GET")) {
			out.print("<h3>Get방식 호출</h3>");
			doGet(req, resp); //HttpServlet에 이미 지정되어 있기 때문에 메소드 선언 없이 바로 사용 가능
		} else if (method.equals("POST")) {
			out.print("<h3>Post방식 호출</h3>");
		}
		
		out.print("<a href='./index.jsp?user_name=gildong&user_id=hong'>index page</a>");
	}
	
	@Override
	public void destroy() { //서블릿이 종료될 때 실행
		System.out.println("destroy() 호출");
	}
}
