<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String[] members = {"김길동","홍길동","김사랑","박사랑"};
	int num1 = 10;
	
	int calc(int num2){
		return this.num1 + num2;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Total</title>
</head>
<body>
	<h3>
	1. JSP 주석
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	</h3>
	
	<h3>
	2. 메서드 실행 결과
	<% calc(10);%>
	<% int num3 = calc(10); out.println(num3);%>
	<%= calc(20)%>
	</h3>
	
	<h3>
	<!--  3. include
	<%@ include file="hello.jsp"%>-->
	</h3>
	
	<h3>
	4. 스크립트
	<ul>
		<%for(String name : members){%>
		<li><%= name%></li>		
		<% }%>
	</ul>
	</h3>
	
	
	
	
</body>
</html>