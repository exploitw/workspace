<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="P.*" %>  
    <%@page import="org.apache.commons.lang3.*" %> 
<%!
public boolean canride(Child child) {
	// boolean rtn = true;
	// return rtn;
	 return true;
	 	 }
%>    

<%!
 String includeTempate ="<h1>Marrygoround</h1>:canride:";
 %>
 <%
 boolean include = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("include"),"false"));
 if(include){
	 Child child = (Child) request.getAttribute("child");
	 String canride = "";
	 if(canride(child)){
		 canride = "탑승 가능";
	 }else{
		 canride = "탑승 불가능";
	 }
	 String htmlPart = includeTempate.replace(":canride:",canride);
	 out.print(htmlPart);
	 return;
 }
 %>
 <jsp:useBean id="child" class="P.Child"/> 
<jsp:setProperty name="child" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MARRYGOROUND</h1>
 <%if (canride(child)) {%>
	탑승가능
	<%} else{ %>
	탑승 불가능
	<%} %> 
</body>
</html>