package customer;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/mcontrol")
public class MadangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerservice;
	OrderingService orderingservice;
	BookService bookservice;
   
    public MadangController() {
        customerservice = new CustomerService();
        orderingservice = new OrderingService();
        bookservice = new BookService();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String view = "";
		if(request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/mcontrol?action=list").forward(request, response);
		}else {
			switch(action) {
			case "addOrdering" :
				addOrdering(request,response);
				view = list(request,response);break;
			case "list": view = list(request,response);break;
			case "info": view = info(request,response);break;
			case "books": view = booklist(request,response);break;
			case "book": view = bookinfo(request,response);break;
			case "setBook" :
				setBook(request,response);
				break;
			case "removeBook" :
				//removeBook(request,response);
				break;
			}
			if(StringUtils.isNoneBlank(view)) {
			getServletContext().getRequestDispatcher("/customer/"+view).forward(request, response);
			}
		}
	}
	private String addOrdering(HttpServletRequest request, HttpServletResponse response)throws IOException {
		try {
			Ordering ordering = new Ordering();
			BeanUtils.populate(ordering, request.getParameterMap());
			orderingservice.add(ordering);
		}catch(IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
			}
		return "Madang.jsp";
	}
	
	
	private String info(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));

        request.setAttribute("customer", customerservice.get(id));
		return "Madang.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("customers", customerservice.findAll());
		request.setAttribute("books", bookservice.findAll());
		request.setAttribute("orderings", orderingservice.findAll());
		return "Madang.jsp";
	}
	
	private String bookinfo(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));

        request.setAttribute("book", bookservice.get(id));

		return "bookInfo.jsp";
	}
	
	private String booklist(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("books", bookservice.findAll());
		return "bookList.jsp";
	}
	
	private String setBook(HttpServletRequest request, HttpServletResponse response)throws IOException{
		try {
			Book book = new Book();
			BeanUtils.populate(book, request.getParameterMap());
			if(book.getId() == -1) {
				bookservice.add(book);
			}else {
				bookservice.set(book);
			}
		}catch(IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "bookList.jsp";
	}
	
	private void removeBook(HttpServletRequest request, HttpServletResponse response)throws IOException {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		
		boolean hasOrdering = false;
		for(Ordering ordering : orderingservice.findAll()) {
			if(ordering.getBookId() == id) {
				hasOrdering = true;
				break;
			}
		}
		
		if(hasOrdering) {
			response.sendRedirect("mcontrol?action=books&hasOrdering=true");
			//return "bookList.jsp";
		}else {
			response.sendRedirect("mcontrol?action=books&hasOrdering=false");
			bookservice.remove(id);
			//return "bookList.jsp";
		}
	}
	
	

}
