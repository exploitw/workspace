<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="P.*" %>   
<%@page import="org.apache.commons.lang3.*" %> 
    
 <%!
 public boolean canride (Child child) {
	 boolean rtn = false;
	 if (child.age >= 6 && child.height >= 120) {
		rtn = true;
	} else {
		if (child.height >=120 && child.withparent == true) {
			rtn = true;
		} else {
			rtn = false;
		}
		return rtn;
	}
	 return rtn;
 }
 %>   
 <%
 String includeTempate ="<h1>Bumpercar</h1>:canride:";
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
 <%-- <%!
 public boolean canRide(Child c){
	 boolean rtn = false;
	 if(c.getAge() >= 6 && c.getHeight() >= 120){
		 rtn = true;
	 }else{
		 if(c.getHeight() >= 120 && c.isWithparent()){
			 rtn = true;
		 }
	 }
	 return rtn;  Child.java 에서 public int age를 private int age로 바꾸고 getAge()로 호출
 }
 %> --%>
<jsp:useBean id="child" class="P.Child"/> 
<jsp:setProperty name="child" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BUMPERCAR</h1>
 <%if (canride(child)) {%>
	탑승가능
	<%} else{ %>
	탑승 불가능
	<%} %> 
</body>
</html>