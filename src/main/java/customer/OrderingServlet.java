package customer;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;


@WebServlet("/orderingservlet")
public class OrderingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   OrderingDAO orderingdao;
   CustomerDAO customerdao;
   BookDAO bookdao;
   public void init(ServletConfig config)throws ServletException {
   	super.init(config);
   	orderingdao = new OrderingDAO();
   	customerdao = new CustomerDAO();
   	bookdao = new BookDAO();
   }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		  String action = request.getParameter("action");
		  String view= "";
		  
		  if(request.getParameter("action")==null) {
			  getServletContext().getRequestDispatcher("/orderingservlet?action=list").forward(request, response);
		  }else {
			  switch(action) {
			  case "list": view = list(request,response); break;
			  
			  }
			  if(StringUtils.isNoneBlank(view)) {
				  getServletContext().getRequestDispatcher("/customer/"+view).forward(request, response);
			  }
		  }
	}

	
	 public String list(HttpServletRequest request,HttpServletResponse response) {
		  request.setAttribute("customers", customerdao.getAll());
		  request.setAttribute("books", bookdao.getAll());
		  request.setAttribute("orderings", orderingdao.getAll());
			return "Madang.jsp";
	  }
}
