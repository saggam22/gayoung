package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("수정처리하는 컨드롤 입니다.");
		String id = request.getParameter("id");
		String ps = request.getParameter("passwd");
		String nm = request.getParameter("name");
		String em = request.getParameter("email");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(ps);
		vo.setName(nm);
		vo.setEmail(em);
		
		MemberService service = new MemberService();
		service.memberUpdate(vo);
		
		request.setAttribute("id", id);
		request.setAttribute("name", nm);
		
		//Dispatcher객체 forward 요청정보를 그대로 지정페이지에서 호출
		request.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(request, response);
	}

}
