<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="P.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHILDLIST</title>
<style>
.red {
	background-color: red;
}

.green {
	background-color: green;
}

td {
	text-align: center;
}
</style>
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

				<%--<c:choose>
                        <c:when test="${child.age >= 6}">
                            <td class="green">${child.age}</td>
                        </c:when>
                        <c:when test="${child.age < 6}">
                            <td class="red">${child.age}</td>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${child.height >= 120}">
                            <td class="green">${child.height}</td>
                        </c:when>
                        <c:when test="${child.height < 120}">
                            <td class="red">${child.height}</td>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${child.withparent}">
                            <td class="green">${child.withparent}</td>
                        </c:when>
                        <c:when test="${child.withparent == false}">
                            <td class="red">${child.withparent}</td>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${child.heartDisease == false}">
                            <td class="green">${child.heartDisease}</td>
                        </c:when>
                        <c:when test="${child.heartDisease}">
                            <td class="red">${child.heartDisease}</td>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${child.canRideRollerCoaster}">
                            <td class="green">${child.canRideRollerCoaster}</td>
                        </c:when>
                        <c:when test="${child.canRideRollerCoaster == false}">
                            <td class="red">${child.canRideRollerCoaster}</td>
                        </c:when>
                    </c:choose> --%>
				<c:choose>
					<c:when test="${child.age >= 6}">
						<td style="color: #0000FF">${child.age}</td>
					</c:when>
					<c:when test="${child.age < 6 }">
						<td style="color: #FF0000">${child.age}</td>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${child.height >= 120}">
						<td style="color: #0000FF">${child.height}</td>
					</c:when>
					<c:when test="${child.height < 120 }">
						<td style="color: #FF0000">${child.height}</td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${!child.withparent}">
						<td style="color: #0000FF">${child.withparent}</td>
					</c:when>
					<c:when test="${child.withparent}">
						<td style="color: #FF0000">${child.withparent}</td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${!child.heartDisease}">
						<td style="color: #0000FF">${child.heartDisease}</td>
					</c:when>
					<c:when test="${child.heartDisease}">
						<td style="color: #FF0000">${child.heartDisease}</td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${child.canRide}">
						<td style="color: #0000FF">${child.canRide}</td>
					</c:when>
					<c:when test="${child.canRide == false}">
						<td style="color: #FF0000">${child.canRide}</td>
					</c:when>
				</c:choose>
				<%-- <td>${child.age}</td>
	<td>${child.height}</td>
	<td>${child.withparent}</td>
	<td>${child.heartDisease}</td>
	<td>${child.canRide}</td> --%>
				<br>
		</c:forEach>
		</tr>

	</table>


</body>
</html>