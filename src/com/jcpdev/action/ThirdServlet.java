package com.jcpdev.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/3th.dev")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//request 애트리뷰트 저장은 없지만 url 패턴을 xxx.dev 로 유지하기 위해 아래 코딩으로 
		//view 를 출력하고 request, response도 전달합니다. 
		RequestDispatcher rd = request.getRequestDispatcher("3th.jsp");
		rd.forward(request, response);			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h4>파라미터</h4>");
		out.print("name : " + name);
		out.print("age : " + age);
	
		//요청메소드 POST 는 데이터 저장(db insert) 동작
		//response.sendRedirect(url);   //출력내용 확인하기 위해 생략.
	}

}
