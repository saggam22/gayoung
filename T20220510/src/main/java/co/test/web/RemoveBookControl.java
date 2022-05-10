package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;

public class RemoveBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		BookService service = new BookService();
		service.removeBook(code);
		
		request.setAttribute("bookCode", code);
		request.getRequestDispatcher("result/removeOutput.jsp").forward(request, response);
	}

}
