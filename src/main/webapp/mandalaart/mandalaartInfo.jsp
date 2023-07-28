<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mandalaartinfo</title>
</head>
<body>
<c:if test="${empty param.goal}">
	<h2>Mandalaart</h2>
	<form method="post" action="/jwbook/mandalaartcontrol?goal=list2">
	<table border="1">
		<c:forEach begin="0" end="2" step="1" varStatus="i">
			<tr>
			<c:forEach begin="0" end="2" step="1" varStatus="j">
				
				 <c:if test="${3 * i.index + j.index ==4}">
				 <td>${mandalaarts[3 * i.index + j.index ].semi_goal}</td>
				</c:if>
				<c:if test="${3 * i.index + j.index !=4}">
				 <td><input type="submit" name= "goal" value="${mandalaarts[3 * i.index + j.index].semi_goal}"></td>
				</c:if> 
			</c:forEach>
			</tr>
		</c:forEach>
		</c:if>
		</table>
		</form>
			<c:if test="${!empty param.goal}">
			<table border="1">
			<c:forEach begin="0" end="2" step="1" varStatus="i">
			<tr>
			<c:forEach begin="0" end="2" step="1" varStatus="j">
			<td>${mandalaarts2[3 * i.index + j.index].detail_goal}</td>
			</c:forEach>
			</c:forEach>
			</c:if>
			</tr>
	</table>
</body>
</html>