package co.edu.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelStudentServ
 */
@WebServlet("/ajax/delStudentServlet")
public class DelStudentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelStudentServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = req.getParameter("delId");
		
		StudentDAO dao = new StudentDAO();
		boolean success = dao.removeStudent(id);
		
		if(success) {
			//{"retCode":"OK", "retVal":id}
			resp.getWriter().print("{\"retCode\":\"OK\", \"retVal\":"+ id +"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"NG\", \"retVal\":" + id + "}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
