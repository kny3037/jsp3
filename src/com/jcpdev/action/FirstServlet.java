package com.jcpdev.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

//서블릿은 http 요청을 처리하는 자바 클래스 입니다. HttpServlet을 상속받습니다.
public class FirstServlet extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	
	//요청 Method 가  Get일 때, 처리되는 메소드 : 메소드 매개변수 타입 req,resp 을 인자로 요청이 들어오면 생성되는 객체를 전달 받습니다. 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request,response 외의 JSP내장객체는 모두 선언해서 사용해야 합니다. 
		// JSP내장객체 out을 선언합니다. 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();   //JspWriter의 부모 PrintWriter 타입으로 선언. 위의 2개 responset set 필요
		//응답할 html 문서의 내용
		out.print("<h3>JSP와 서블릿</h3>");
		out.print("서블릿 너는 도대체 뭐냐?");
		
		//현재 request 객체에 대한 세션객체가 필요하다면 
		HttpSession session = request.getSession();
		session.setAttribute("data", "first");
		
		//1) request에 애트리뷰트 객체 저장(선택)
		request.setAttribute("number", 123);
		//pageContext.forward("first.jsp"); -> pageContext는 JSP 파일에서만 사용할 수 있는 내장객체
		//서블릿에서는 다음(RequestDispatcher) 객체를 사용합니다.
		//first.jsp(view 파일)가 현재의 request, response 전달받을 수 있도록 감싸는 객체가 RequestDispatcher
		
		//2) view 파일로 forward
		RequestDispatcher rd = request.getRequestDispatcher("first.jsp");
		rd.forward(request, response);
		
	}
	
	//요청 Method 가  Post일 때, 처리되는 메소드 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
