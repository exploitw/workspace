package mandalaart;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;




@WebServlet("/mandalaartcontrol")
public class MandalaartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	mandalaartDAO dao;
    public void init(ServletConfig config)throws ServletException {
    	super.init(config);
    	dao = new mandalaartDAO();
    }
   
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String goal = StringUtils.defaultIfEmpty(request.getParameter("goal"),"");
		String action = request.getParameter("action");
		String view = "";
		
		if(request.getParameter("action")== null) {
			getServletContext().getRequestDispatcher("/mandalaartcontrol?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list": view = list(request,response);break;
			case "list2": view = list2(request,response);break;
			
			
			default:		response.sendRedirect("mandalaartcontrol?action=list");
			break;
			}
			if(StringUtils.isNoneBlank(view)) {
			getServletContext().getRequestDispatcher("/mandalaart/"+view).forward(request, response);
			}
		}
	}

	public String list (HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("mandalaarts", dao.getAll());
		return "mandalaartInfo.jsp";
		
	}
	public String list2 (HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("mandalaarts2", dao.getAll2());
		return "mandalaartInfo.jsp";
		
	}
	

}
