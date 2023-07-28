<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="P.*" %>    
<%@page import="org.apache.commons.lang3.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%

Random random = new Random();

int[] ageRange = new int[17];
int[] heightRange = new int[160];
for (int i = 0; i < ageRange.length; i++) {
	ageRange[i] = i + 1;
}
for (int i = 0; i < heightRange.length; i++) {
	heightRange[i] = i + 40;
}



Child[] childs = new Child[100];
for (int i = 0; i < childs.length; i++) {

	childs[i] = new Child(ageRange[random.nextInt(ageRange.length)], heightRange[random.nextInt(heightRange.length)],
	random.nextBoolean(), Math.random() < 0.01 ? true : false);
	//System.out.println(childs[i]);
}

request.setAttribute("childs",childs);
/* pageContext.setAttribute("childs",childs); */
%>
<jsp:forward page="Child2.jsp"/>

<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHILDLIST</title>
</head>
<body>

	<table border="1">
	<tr>
	<th>나이</th>
	<th>키</th>
	<th>부모동반</th>
	<th>심장병</th>
	<th>탑승</th>
	</tr>
	<c:forEach var="child" items="${childs}">
	<tr>
		
	
	<c:choose>
	<when test="${child.age >= 6}">
	 	<td style="color:#0000FF">${child.age}</td>
	</when>
	<when test="${child.age < 6 }">
		<td style="color:#FF0000">${child.age}</td>
	</when>
	</c:choose>
	<c:choose>
	<when test="${child.age >= 6}">
	 	<td style="color:#0000FF">${child.age}</td>
	</when>
	<when test="${child.age < 6 }">
		<td style="color:#FF0000">${child.age}</td>
	</when>
	</c:choose>
	<c:choose>
	<when test="${child.age >= 6}">
	 	<td style="color:#0000FF">${child.age}</td>
	</when>
	<when test="${child.age < 6 }">
		<td style="color:#FF0000">${child.age}</td>
	</when>
	</c:choose>
	<c:choose>
	<when test="${child.age >= 6}">
	 	<td style="color:#0000FF">${child.age}</td>
	</when>
	<when test="${child.age < 6 }">
		<td style="color:#FF0000">${child.age}</td>
	</when>
	</c:choose>
	<c:choose>
	<when test="${child.age >= 6}">
	 	<td style="color:#0000FF">${child.age}</td>
	</when>
	<when test="${child.age < 6 }">
		<td style="color:#FF0000">${child.age}</td>
	</when>
	</c:choose>
	<td>${child.age}</td>
	<td>${child.height}</td>
	<td>${child.withparent}</td>
	<td>${child.heartDisease}</td>
	<td>${child.canRide}</td>
	<br>
	
	</c:forEach>
	</tr>
	
	</table>


</body>
</html> --%>