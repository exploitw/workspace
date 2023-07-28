<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<c:set var="product1" value="<b>애플 아이폰</b>"/>
<c:set var="product2" value="삼성 갤럭시 노트"/>
<%-- <c:set var="intArray" value="${[1,2,3,4,5]}" /> --%>
<c:set var="checkout" value="true"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:out value="product1"/><br>
	<c:out value="${product1}" default="Not registered" escapeXml="true"/><br>
	${product1}<br>
	<c:out value="${intArray}"/><br>
	<c:out value="${intArray[2]}"/><br>
	${intArray[2]}<br>
	
	<ul>
	<c:forEach var="num" items="${intArray}" varStatus="i">
	 <li>${i.index} : ${num}</li>
	</c:forEach> 
	</ul>
	
	<c:if test="${checkout ne false}">
	<p>주문 제품</p>
	</c:if>
	<c:if test="${!empty product2}">
	<c:out value="${product2}"/>애플
	</c:if>
	<br>
	<c:choose>
		<c:when test="${!checkout}">
		${product2}
		</c:when>
		<c:when test="${checkout}">
		애플
		</c:when>
		<c:otherwise>
		애플
		</c:otherwise>
	</c:choose>
	<br>
	<c:forTokens varStatus ="i" var="city" items="서울,도쿄,뉴욕,토론토" delims=",">
	${city}
	<c:if test="${!i.last}">,</c:if>
	</c:forTokens>
	
	
	
</body>
</html>