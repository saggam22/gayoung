package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet({ "/SampleServlet", "/sampleServlet" })
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //service 메소드 없이 선언 없이 doGet, doPost 메소드 사용
    //나눠서 사용하지 않고 service를 사용해도 무관하다

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //get방식
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //post방식
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
