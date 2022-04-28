package co.edu.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModStudentServlet
 */
@WebServlet("/ajax/modStudentServlet")
public class ModStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=uft-8");
		
		String sNo = request.getParameter("a");
		String sName = request.getParameter("b");
		String eng = request.getParameter("c");
		String kor = request.getParameter("d");
		
		Student std = new Student();
		std.setStudentNo(Integer.parseInt(sNo));
		std.setStudentName(sName);
		std.setEngScore(Integer.parseInt(eng));
		std.setKorScore(Integer.parseInt(kor));
		
		StudentDAO dao = new StudentDAO();
		boolean success = dao.modifyStudent(std);
		//성공하면 {"retCode":"OK", "studentNo":sNo,"studentName":"sName","engScore":eng,"korScore":kor}
		if(success) {
			response.getWriter().println("{\"retCode\":\"OK\", \"studentNo\":"+sNo+", \"studentName\":\""+sName+"\", \"engScore\":"+eng+", \"korScore\":"+kor+"}");	
		} else {
			response.getWriter().println("{\"retCode\":\"NG\"}");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
