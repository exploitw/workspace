<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- <%
long result = 0;
String ss = request.getParameter("n1");
String[] values;

if(ss.indexOf("+") != -1){
	 values = ss.split("\\+");
	int n1 = Integer.parseInt(values[0]);
	int n2 = Integer.parseInt(values[1]);
	result = n1 + n2;
}else if(ss.indexOf("-") != -1){
	values = ss.split("-");
	int n1 = Integer.parseInt(values[0]);
	int n2 = Integer.parseInt(values[1]);
	result = n1 + n2;
}else if(ss.indexOf("*") != -1){
	values = ss.split("\\*");
	int n1 = Integer.parseInt(values[0]);
	int n2 = Integer.parseInt(values[1]);
	result = n1 * n2;
}else if(ss.indexOf("/") != -1){
	values = ss.split("/");
	int n1 = Integer.parseInt(values[0]);
	int n2 = Integer.parseInt(values[1]);
	result = n1 / n2;
}
%>     -->    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 계산 결과-JSP</h2>
	<hr>
	결과: <%=result %>
</body>
</html>