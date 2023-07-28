<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@ page import="P.*" %>    
<%@page import="org.apache.commons.lang3.*" %>     
<%!
public boolean canride(Child child) {
	
	boolean rtn =false;
	if(child.heartDisease == false) {
		if (child.age >= 6 && child.height >= 120) {
			rtn = true;
		} else {
			if (child.height >=120 && child.withparent == true) {
				rtn = true;
			} else {
				rtn = false;
			}
		}
	}else {
		rtn = false;
	}
	return rtn;
	
	
}

%> 

<% 
	 Child child = (Child) request.getAttribute("child");
	 String canride = "";
	 if(canride(child)){
		 canride = "탑승 가능";
	 }else{
		 canride = "탑승 불가능";
	 }

 %>  




	<h1>ROLLERCOASTER</h1>
	<%= canride%>
