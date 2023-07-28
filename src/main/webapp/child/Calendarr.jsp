<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.*"
    import="java.time.temporal.*"
    import="java.util.stream.*" 
    import= "java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 

LocalDate ld = LocalDate.of(2023,7,1);
String lld = ld.toString();
LocalDate start = ld.with(
		TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)
		);
LocalDate end = start.plusDays(42);
List<LocalDate> days = start.datesUntil(end).collect(Collectors.toList());
pageContext.setAttribute("days",days);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canlendar Making</title>
</head>
<body>
<p>2023년 7월</p>
    <table border="1" width="700" height="200">
    <c:set var="i" value="0"/>
    <c:forEach begin="1" end="6">
    <tr>
    	<c:forEach begin="1" end="7">
    	<td>
    	<c:if test="${days[i].monthValue == 7 }">
    	<c:out value="${days[i]}"/>
    	</c:if>
    	</td>
    	<c:set var ="i" value="${i + 1}"/>
    	</c:forEach>
    	</tr>
    	</c:forEach>
   
   
   
   
    </table>
</body>
</html>