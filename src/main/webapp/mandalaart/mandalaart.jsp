<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MANDALAART</title>
</head>
<body>
	<form action="<c:url value="/mandalaartt"/>" method="get">
	<table>
	<c:forEach var="i" begin="0" end="2">
	 <tr>
	 	<c:forEach var="j" begin="0" end="2">
		 <c:if test="${3 * i + j ==4}">
				 <td>${firstList[3 * i + j ]}</td>
				</c:if>
				<c:if test="${3 * i + j !=4}">
				 <td><input type="submit" name= "goal" value="${firstList[3 * i + j]}"></td>
				</c:if> 
		</c:forEach>
			 
	 </tr>
	 </c:forEach>
	 <tr></tr>
	 <tr></tr>
	</table>
	</form>
	
	<c:if test="${! empty param.goal}">
	<table>
	<c:forEach begin="0" end="2"  var="i">
			<tr>
			<c:forEach begin="0" end="2"  var="j">
			<td>${secondList[3 * i + j]}</td>
			</c:forEach>
			</tr>
			</c:forEach>
	</table>
	</c:if>
	
</body>
</html>