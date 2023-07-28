package customer;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/ccontrol")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustomerService service;
       OrderingService orderingService;
    public CustomerController() {
    	service = new CustomerService();
    	orderingService = new OrderingService();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		String view ="";
		
		if(request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/ccontrol?action=list").forward(request, response);
		}else {
			switch(action) {
			case "setCustomer" :
				setCustomer(request,response);
				view = list(request,response);break;
			case "list": view = list(request,response);break;
			case "info": view = info(request,response);break;
			case "removeCustomer":
                
                removeCustomer(request, response);
                //view = list(request, response); void removecustomer이면 주석처리
                break;
			
			}
			if(StringUtils.isNoneBlank(view)) {
			getServletContext().getRequestDispatcher("/customer/"+view).forward(request,response);
		    }
		}
	}
	private String setCustomer(HttpServletRequest request, HttpServletResponse response)throws IOException {
		try {
			 Customer customer = new Customer();
	            BeanUtils.populate(customer, request.getParameterMap());
	            if (customer.getId() == -1) {
	                service.add(customer);
	            } else {
	                service.set(customer);
	            }
	            //response.sendRedirect("ccontrol?action=list");
		}catch(IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
			}
		return "customerList.jsp";
	}
	
	private String info(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		 List<Customer> customers = service.findAll();
        request.setAttribute("customer", service.get(id));

		return "customerInfo.jsp";
	}
	private String list(HttpServletRequest request, HttpServletResponse response) {
		//boolean hasOrdering = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrdering"),"false"));
		//request.setAttribute("hasOrdering", hasOrdering); 파라미터값으로 hasOrdering을 받을떼
		
		
		/*
		if(Boolean.TRUE.equals(request.getSession().getAttribute("hasOrdering"))) {
			
		}else {
			request.getSession().setAttribute("hasOrdering", false);
		}*/
		//session으로 hasordering 받을떼
		if(request.getSession().getAttribute("hasOrdering") == null) {
			request.getSession().setAttribute("hasOrdering", false);
		}
		
		request.setAttribute("customers", service.findAll());
		return "customerList.jsp";
	}
	private void removeCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
       boolean hasOrdering = false;
       for(Ordering ordering : orderingService.findAll()) {
    	   if(ordering.getCustomerId() == id) {
    		   hasOrdering = true;
    		   break;
    	   }
       }
       if(hasOrdering) {
    	   //response.sendRedirect("ccontrol?action=list&hasOrdering=true");
    	   request.getSession().setAttribute("hasOrdering", true);
    	   response.sendRedirect("ccontrol?action=list");
       }else {
    	   service.remove(id);
    	   //response.sendRedirect("ccontrol?action=list&hasOrdering=false");
    	   request.getSession().setAttribute("hasOrdering",false);
    	   response.sendRedirect("ccontrol?action=list");
       }
    		 
        
	}
	
}
