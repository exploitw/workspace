package customer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;


@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   BookDAO dao;
   public void init(ServletConfig config)throws ServletException {
   	super.init(config);
   	dao = new BookDAO();
   }
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		  String action = request.getParameter("action");
		  String view= "";
		  
		  if(request.getParameter("action")==null) {
			  getServletContext().getRequestDispatcher("/bookservlet?action=list").forward(request, response);
		  }else {
			  switch(action) {
			  case "list": view = list(request,response); break;
			  case "insert": insert(request,response); break;
			  }
			  if(StringUtils.isNoneBlank(view)) {
				  getServletContext().getRequestDispatcher("/customer/"+view).forward(request, response);
			  }
		  }
	  }

	  public String list(HttpServletRequest request,HttpServletResponse response) {
		  request.setAttribute("books", dao.getAll());
			return "bookList.jsp";
	  }
	  
	  public void insert(HttpServletRequest request, HttpServletResponse response)throws IOException{
		  Book b = new Book();
		  try {
			  BeanUtils.populate(b,request.getParameterMap());
		  }catch(IllegalAccessException | InvocationTargetException e) {
			  e.printStackTrace();
		  }
		  dao.insert(b);
		  response.sendRedirect("/jwbook/bookservlet?action=list");
	  }
	  

}
