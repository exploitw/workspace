<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerList</title>
</head>
<div data-role="appbar">
            <ul class="app-bar-menu">
               <li><a href='<c:url value="/mcontrol"/>'>주문</a></li>
	  <li><a href='<c:url value="/ccontrol"/>'>고객</a></li>
	  <li><a href='<c:url value="/mcontrol?action=books"/>'>도서</a></li>
            </ul>
        </div>

        <br />
        <br />
        <br />

<body>
	<div class="container">
		<div class="container">
			<label>고객</label>
		</div>
		<br>
		<table class="table">
		
		 <thead >
		 <tr>
		  <th>고객번호</th>
		  <th>고객명</th>
		  <th>주소</th>
		  <th>전화번호</th>
		 </tr>
		
		 </thead>
		 <tbody id="customers">
		  <c:forEach var="c" varStatus="i" items="${customers}">
		 	<tr>
		 	 <td><a href="/jwbook/ccontrol?action=info&id=${c.id}"data-id="${c.id}">${i.count}</a></td>
		 	 <td>${c.name}</td>
		 	 <td>${c.address}</td>
		 	 <td>${c.phone}</td>
		 	</tr>
		 </c:forEach>
		 </tbody>
		</table>
		<div class="container">
	<%-- 	<form action='<c:url value="/customerservlet"/>' method ="get" id="goto_form"> --%>
	<form action='<c:url value="/ccontrol"/>' method ="get" id="goto_form"> 
			<input type="hidden" name ="action" value="info"/>
			<input type="hidden" name ="id" value="-1"/>
			<input type="submit" value="추가" id="add_button"/>
		</form>
		</div>
		<!-- <button><a href="/jwbook/ccontrol?action=info&id=-1">추가</button> -->
	
	<script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>
      <script>
            let hasOrdering = ${hasOrdering};
            $(function () {
                if (hasOrdering) {
                    alert('주문이 있습니다.');
                }
            });
        </script>
        <c:set var="hasOrdering" scope="session" value="false"/>
      
        <!-- <script src="customers.js"></script> -->
</body>

</html>