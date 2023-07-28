<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Child 2</title>

        <style>
            .red{
                background-color: red;
            }
            .green{
                background-color: green;
            }
            
            td{
            	text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Child List</h1>
        <table border="1">
            <tr>
                <th>No</th>
                <th>나이</th>
                <th>키</th>
                <th>부모동반</th>
                <th>심장병</th>
                <th>탑승</th>
            </tr>
            <c:forEach var="child" items="${childList}" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <c:choose>
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
                        <c:when test="${child.parent}">
                            <td class="green">${child.parent}</td>
                        </c:when>
                        <c:when test="${child.parent == false}">
                            <td class="red">${child.parent}</td>
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
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>