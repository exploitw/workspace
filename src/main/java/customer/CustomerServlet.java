package customer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import ch09.Student;




@WebServlet("/customerservlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustomerDAO dao;
    public void init(ServletConfig config)throws ServletException {
    	super.init(config);
    	dao = new CustomerDAO();
    }
   
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  String action = request.getParameter("action");
	  String view= "";
	  
	  if(request.getParameter("action")==null) {
		  getServletContext().getRequestDispatcher("/customerservlet?action=list").forward(request, response);
	  }else {
		  switch(action) {
		  case "list": view = list(request,response); break;
		  case "insert": 
			  //view = 
			  insert(request,response); break;
		  case "delete":
			  delete(request,response); break;
		  }
		  if(StringUtils.isNoneBlank(view)) {
			  getServletContext().getRequestDispatcher("/customer/"+view).forward(request, response);
		  }
	  }
  }

  public String list(HttpServletRequest request,HttpServletResponse response) {
	  request.setAttribute("customers", dao.getAll());
		return "customerList.jsp";
  }
  
  public void insert(HttpServletRequest request, HttpServletResponse response)throws IOException {
	  
	  Map map = request.getParameterMap();
		Customer c = new Customer();
		try{
		 BeanUtils.populate(c,map);
		}catch(IllegalAccessException | InvocationTargetException e){
			 e.printStackTrace();
			}

			dao.insert(c);

		response.sendRedirect("/jwbook/customerservlet?action=list");
	  
	  
	  /*
	  Customer c = new Customer();
	  try {
		  BeanUtils.populate(c, request.getParameterMap());
	  }catch(Exception e) {
		  e.printStackTrace();
	  }dao.insert(c);
	  return list(request,response);*/
  }
  public void delete(HttpServletRequest request, HttpServletResponse response)throws IOException {
	  int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
	  Map map = request.getParameterMap();
	  
	  Customer c = new Customer();
	  try {
		  BeanUtils.populate(c,map);
		  
	  }catch(IllegalAccessException | InvocationTargetException e) {
		  e.printStackTrace();
	  }
	  dao.remove(id);
	  response.sendRedirect("/jwbook/customerservlet?action=list");
  }
  
  
  
	

}