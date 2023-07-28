package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name="Hello", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet  {
	String name0;
	String name1;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		
		name0 = sc.getInitParameter("name0");
		name1 = sc.getInitParameter("name1");
		System.out.println("Hello World!");
		
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int i =0;
		request.getServletContext().setAttribute("username", "홍길동");
		
		RequestDispatcher rd = request.getRequestDispatcher("requestheader");
		rd.forward(request, response);
		
		//response.sendRedirect("/jwbook/requestheader");
		//response.sendRedirect("http://www.naver.com");
		//response.addHeader("Refresh", "5; url=hello");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>HELLO 안녕</title></head>");
		out.println("<body>");
		//out.println("<h1>"+ name0 + "</h1>");
		out.println("<h1>" + i + "</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String n1String = request.getParameter("n1");
		String n2String =request.getParameter("n2");
		String opString =request.getParameter("op");
		
		int n1 = Integer.parseInt(n1String);
		int n2 = Integer.parseInt(n1String);
		int result = 0;
		switch(opString) {
		case "+":
			result =n1 + n2;
			break;
		case "-":
			result =n1 - n2;
			break;
		case "*":
			result =n1 * n2;
			break;
		case "/":
			result =n1 / n2;
			break;	
		}
	
	
	}
	
	
	/*	
	@Override
	public void destroy() {
		name0 = null;
		name1 = null;
		System.out.println("Hello destroyed");
	}*/
	
	
	
	
	
}