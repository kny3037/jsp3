package com.jcpdev.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "두 번째 서블릿 연습", urlPatterns = { "/second.dev" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();   //JspWriter의 부모 PrintWriter 타입으로 선언. 위의 2개 responset set 필요
		//응답할 html 문서의 내용
		out.print("<h3>JSP와 서블릿</h3>");
		out.print("서블릿 너는 도대체 뭐냐?");
		
		//현재 request 객체에 대한 세션객체가 필요하다면 
		HttpSession session = request.getSession();
		session.setAttribute("message", "second");
		
//		request.setAttribute("number", 999);
		
//		response.sendRedirect("second.jsp");  //서블릿은 url 패턴(xxx.dev)을 적용하면 jsp 파일로 리다이렉트 안합니다. 
		
		//***url 요청을 바꿉니다.(리다이렉트)->url 지정합니다.
		response.sendRedirect("first.dev");
//		response.sendRedirect(request.getContextPath());   //context path("/")로 리다이렉트
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
