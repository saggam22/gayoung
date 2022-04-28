package co.edu.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/addStudentServlet") //post.html안에 form의 action주소
public class AddStudentServ extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //요청 정보에 포함되어 있는 한글 정보를 처리
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");//응답 정보에 포함되어 있는 한글 정보를 처리
		
		//post.html의 input tag안의 정보를 가져옴
		String studentNo = req.getParameter("sno");
		String studentName = req.getParameter("sname");
		String engScore = req.getParameter("eScore");
		String korScore = req.getParameter("kScore");
		
		Student stud = new Student();
		stud.setStudentNo(Integer.parseInt(studentNo));
		stud.setStudentName(studentName);
		stud.setEngScore(Integer.parseInt(engScore));
		stud.setKorScore(Integer.parseInt(korScore));
		
		//db insert
		StudentDAO dao = new StudentDAO();
		boolean sucess = dao.addStudent(stud);
		if (sucess) {
			//성공하면 {"retCode":"Success", "studNo":studentNo, "studName":"studenName", "engScore":engScore, "korScore":korScore} json형태의 문자열을 출력함
			resp.getWriter().println("{\"retCode\":\"Success\", \"studentNo\":"+ studentNo + ", \"studentName\":\"" + studentName + "\", \"engScore\":"+ engScore + ", \"korScore\":"+ korScore + "}");
		} else {
			//성공하면 {"retCode":"Fail"}
			resp.getWriter().println("{\"retCode\":\"Fail\"}");	
		}
	}
}
