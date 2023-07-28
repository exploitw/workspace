package ch09;

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

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   StudentDAO dao;
    public void init(ServletConfig config)throws ServletException {
    	super.init(config);
    	dao = new StudentDAO();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String view = "";
		
		if(request.getParameter("action")== null) {
			getServletContext().getRequestDispatcher("/studentControl?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list": view = list(request,response);break;
			case "insert":
				
				//view =
				insert(request,response);
				//response.sendRedirect("studentControl?action=list");
			break;
			
			default:		response.sendRedirect("studentControl?action=list");
			break;
			}
			if(StringUtils.isNoneBlank(view)) {
			getServletContext().getRequestDispatcher("/ch09/"+view).forward(request, response);
			}
		}
	}

	public String list (HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("students", dao.getAll());
		return "studentInfo.jsp";
		
	}
	
	public void insert  (HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		Map map = request.getParameterMap();
		Student s = new Student();
		try{
		 BeanUtils.populate(s,map);
		}catch(IllegalAccessException | InvocationTargetException e){
			 e.printStackTrace();
			}

			dao.insert(s);

		response.sendRedirect("/jwbook/studentControl?action=list");
		
		/*Student s = new Student();
		try {
			BeanUtils.populate(s, request.getParameterMap());
		}catch(Exception e) {
			e.printStackTrace();
		}
		dao.insert(s);
		
		return list(request,response);*/
	}
	
}
