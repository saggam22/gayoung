package co.dev.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/fileUploadServlet")
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FileUploadServ() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title: " + title + ", content: " + content); //multipart요청일 경우에는 reqeust로 파라메타값을 읽어올 수 없음
		
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir); //getServletContext() 프로젝트명 .getRealPath(saveDir) 폴더명을 읽어옴
		int maxSize = 1024*1024*5; //(5메가바이트)
		String encoding = "UTF-8";
		
		//multipart 요청
		//request, 저장위치, 최대사이즈, 인코딩, 리네임정책(똑같은 이름을 방지하기 위함 DefaultFileRenamePolicy()는 file.jsp file1.jsp 시퀀스를 증가시킴)
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		
		String profile = multi.getOriginalFileName("profile");
		String fileName = multi.getFilesystemName("profile");
		System.out.println("title: " + title + ", content: " + content + ", profile: " + profile + ", fileName: "+ fileName);
	}

}
