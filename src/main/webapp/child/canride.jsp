<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="P.*" %>    
<%@page import="org.apache.commons.lang3.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@page import ="org.apache.commons.beanutils.*" %>  
<%@page import="java.util.*" %>
    
<%
/* request.setCharacterEncoding("UTF-8");
String ageString = request.getParameter("age");
String heightString = request.getParameter("height");
String withparentString = request.getParameter("withparent");
String heartDiseaseString = request.getParameter("heartDisease");
String[] attractions = request.getParameterValues("attractions");  

int age;
int height;
boolean withparent;
boolean heartDisease;

age = Integer.parseInt(StringUtils.defaultIfEmpty(ageString, "0"));
height = Integer.parseInt(StringUtils.defaultIfEmpty(heightString,"0"));
withparent = Boolean.parseBoolean(StringUtils.defaultIfEmpty(withparentString,"false"));
heartDisease = Boolean.parseBoolean(StringUtils.defaultIfEmpty(heartDiseaseString,"false"));
attractions = ArrayUtils.nullToEmpty(attractions);

Child child = new Child();
child.setAge(age);
child.setHeight(height);
child.setWithparent(withparent);
child.setHeartDisease(heartDisease);
child.setAttractions(attractions);

pageContext.setAttribute("child",child); */
/*
if(ageString == null || "".equals(ageString)){
	age = 0;
}else{
	age = Integer.parseInt(ageString);
}
if(heightString == null || "".equals(heightString)){
	height = 0;
}else{
	height = Integer.parseInt(heightString);
}
if(withparentString == null){
	withparent = false;
}else{
	withparent = Boolean.parseBoolean(withparentString);
}
if(heartDiseaseString == null){
	heartDisease = false;
}else{
	heartDisease = Boolean.parseBoolean(heartDiseaseString);
}
if(attractions == null){
	attractions = new String[0];
}else{
	
}*/



%>
<%-- <jsp:useBean id="child" class="P.Child" scope="request"/> Child child = new Child(); 이것과 동일  <jsp:setProperty name="child" property="*"/>
<jsp:setProperty name = "child" property="age"/>
<jsp:setProperty name = "child" property="height"/>
<jsp:setProperty name = "child" property="withparent"/>
<jsp:setProperty name = "child" property="heartDisease"/>
<jsp:setProperty name = "child" property="attractions"/>    --%>  

<% 
java.util.Map<String,String[]> map = request.getParameterMap();
System.out.println(map);
for(Map.Entry<String,String[]> e : map.entrySet()){
	System.out.println(e.getKey());
	for(String s : e.getValue()){
		System.out.println(s);
	}
}
Child child = new Child();
BeanUtils.populate(child, map);
System.out.println(child);


pageContext.setAttribute("child",child);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--  <jsp:getProperty name="child" property="age"/>
	<jsp:getProperty name="child" property="height"/>
	<jsp:getProperty name="child" property="withparent"/>
	<jsp:getProperty name="child" property="heartDisease"/>
	<jsp:getProperty name="child" property="attractions"/> 
	<jsp:getProperty name="child" property="canRide"/>         
	  --%>
	<%-- <%= child.getAge()%><br>
	<%= child.getHeight() %><br>
	<%= child.isWithparent() %><br>
	<%= child.isHeartDisease() %><br>
	<%= child.getAttractions() %><br>
	<%for(String attraction : child.getAttractions()){%>
		 <%=attraction%> 
		<%}%>
	
	<%for(String attraction : child.getAttractions()){%>
		 <%=attraction%> 
		<%}%> --%>
	<%-- 	
	 ${child.age}<br>
	${child.height}<br>
	${child.withparent}<br>
	${child.heartDisease}<br>
	${child.attractions}<br> 
	${child.canRide}	
		 --%>
		 <%-- <jsp:param name="attraction" value ="<%= attraction%>"/> --%>
		 <%-- <jsp:param name="include" value ="true"/> --%>
	<%-- <% for(String attraction : child.getAttractions()){	%>
	<jsp:include page='<%= attraction + ".jsp"%>'>
		<jsp:param name="include" value ="true"/>
		
		</jsp:include>
		<%} %>	 
		 --%>
		 ${child.age}<br>
		 ${child.height}<br>
		 ${child.withparent}<br>
		 ${child.heartDisease}<br>
		 <c:forEach var = "attraction" items="${attractions}">
		 ${attraction}<br>
		 </c:forEach>
		
		
	
	
</body>
</html>