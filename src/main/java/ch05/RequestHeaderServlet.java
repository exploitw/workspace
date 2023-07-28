package ch05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/requestheader")
public class RequestHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
String htmlTemplate ="""
<!DOCTYPE html>
<html>
<head><title>RequestHeader</title></head>
<body>
<h1>:username:</h1>
<h1>:result:</h1>
</body>
</html>
""";      
    
    public RequestHeaderServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			
			sb.append(headerName);
			sb.append(": ");
			sb.append(headerValue);
			sb.append("<br>");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = htmlTemplate.replace(":result:",sb.toString());
		String s =(String) request.getServletContext().getAttribute("username");
		
		html = html.replace(":username:", "홍길동");
		out.println(html);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
