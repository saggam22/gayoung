package co.edu.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/MyToDoListServlet")
public class MyToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyToDoListServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체조회
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		
		ToDoDAO dao = new ToDoDAO();
		List<ToDoVO> list = dao.getList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list)); //json 타입 생성
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력, 삭제
		request.setCharacterEncoding("UTF-8");
		
		String job = request.getParameter("job");
		ToDoDAO dao = new ToDoDAO();
		if (job.equals("insert")) {
			String todo = request.getParameter("todo");
			
			ToDoVO vo = new ToDoVO(todo);
			dao.insertSchedule(vo);
			
		} else if (job.equals("delete")) {
			String todo = request.getParameter("todo");
			dao.deleteSchedule(todo);
		}
	}

}
