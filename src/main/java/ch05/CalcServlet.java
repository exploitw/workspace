package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		
		String op = request.getParameter("op");
		
		long result = 0;
		switch(request.getParameter("op")) {
		case "+": result = n1 + n2; break;
		case "-": result = n1 - n2; break;
		case "*": result = n1 * n2; break;
		case "/": result = n1 / n2; break;
		
		}
		*/
		/*
		String drink = request.getParameter("drink");
		String result1 = "";
		if(drink == null) {
			result1 = "N/A";
		}else {
			String[] drinks = request.getParameterValues("drink");
			for(String d : drinks) {
				result1 += (d + ",");
			}
		}
		*/
		int age = Integer.parseInt(request.getParameter("age"));
		int height = Integer.parseInt(request.getParameter("height"));
		boolean withparent = Boolean.parseBoolean(request.getParameter("withparent"));
		boolean heartDisease = Boolean.parseBoolean(request.getParameter("heartDisease"));
		
		
		boolean rtn;
    	if(heartDisease == false) {
    		if (age >= 6 && height >= 120) {
    			rtn = true;
    		} else {
    			if (height >=120 && withparent == true) {
    				rtn = true;
    			} else {
    				rtn = false;
    			}
    		}
    	}else {
    		rtn = false;
    	}
    	
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<html><body><h2>계산기 서블릿</h2><hr>")
		.append("계산 결과: "+rtn+"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
