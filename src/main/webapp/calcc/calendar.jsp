<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.*" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Calendar c = Calendar.getInstance();
 c.set(Calendar.YEAR,2023);
    c.set(Calendar.MONTH ,7 -1);
    c.set(Calendar.DATE, 1);

    int 요일 = c.get(Calendar.DAY_OF_WEEK);
    if(요일 == Calendar.SUNDAY) {

    c.add(Calendar.DATE, 0);

    }else if(요일 == Calendar.MONDAY) {
    	c.add(Calendar.DATE, -1);
    }else if(요일 == Calendar.TUESDAY) {
    	c.add(Calendar.DATE, -2);
    }else if(요일 == Calendar.WEDNESDAY) {
    	c.add(Calendar.DATE, -3);
    }else if(요일 == Calendar.THURSDAY) {
    	c.add(Calendar.DATE, -4);
    }else if(요일 == Calendar.FRIDAY) {
    	c.add(Calendar.DATE, -5);
    }else if(요일 == Calendar.SATURDAY) {
    	c.add(Calendar.DATE, -6);
    }
    //c.add(Calendar.DATE, +1);
    int mm = c.get(Calendar.MONTH) + 1;	
    %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Sample jsp</title>
    <style>
    h1 {font-size:16pt; background:#AAFFAA; padding:5px; }
    </style>
</head>
<body>
	 <table border="1" width="200" height="100">
    
   
   
  
   
   
   
     <%for(int i = 0; i < 6; i++) { %>
    <tr>
    	<%for(int j = 0; j < 7; j++) { %>
    		<td>
    		<% if(c.get(Calendar.MONTH) != mm) {%>
    		<%="  "+ "\t" %>
    		<% }else {%>
    		<%= c.get(Calendar.DATE)+ "\t"%>
    		<% }%>
    		<%c.add(Calendar.DATE,1); %>
    <%} %><br>
    </td>
		<%} %>
		</tr> 
     
    </table> 
    
</body>
</html>
<!-- for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				
				if(c.get(Calendar.MONTH) != mm) {
					sout.print("  "+ "\t");
				}else {
					sout.print(c.get(Calendar.DATE)+ "\t");
				}
				c.add(Calendar.DATE,1);
			}sout.println();
		} -->