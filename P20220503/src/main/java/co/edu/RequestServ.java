package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServ
 */
@WebServlet("/request1.do")
public class RequestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServ() {
        super();
        // TODO Auto-generated constructor stub
    }

  //jsp 상태 정보 유지하는 방법
  //application : P20220503/P20220504/ <- tomcat 서버에서 각각의 프로젝트가 실행(어플리캐이션의 각 단위 프로젝트)
  //session : user1/ user2/ user3 <- P20220503/ 동일한 프로젝트의 다른 사용자들(세션의 각 단위 사용자)
  //request : page1/ page2        <- servlet1, servlet2 페이지1에서 내부적으로 페이지2로 정보를 공유하는 방법
  //request.jsp -> request1.do 로 값을 넘기고 request1.do -> request.jsp로 결과를 넘긴다 처리가 끝났는데도 request 객체가 살아있어 호출이 가능
  // http 프로토콜
  //클라이언트 request -> 서버
  //클라이언트 response <- 서버
  //=> 처리결과를 받아온 후에 http연결은 끊어지면서 request, response은 사라진다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		
		StudentDAO dao = new StudentDAO();
		Student result = dao.searchStudent(id);
		request.setAttribute("result", result);
		
		//response.jsp
		//페이지를 재지정하는 방법 두가지
		request.getRequestDispatcher("response.jsp").forward(request, response);//정보를 response.jsp로 포워딩할 때 매개값으로 request1.do에서 받은 리퀘스트 값을 공유
		//또 다른 jsp페이지에서 reqeust.getA~불러올 수 없다. 페이지를 response.jsp로 지정했기 때문에
		//response.sendRedirect("response.jsp"); //리퀘스트 값을 공유하지 못함
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
