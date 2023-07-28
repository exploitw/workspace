<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
 		



	<form action = '<c:url value="/mcontrol?action=addOrdering"/>' method="post" id="ordering_form">
	<label>고객</label>
	</br>
	<c:forEach var="c" varStatus="i" items="${customers}">
		<input type="radio" name="customerId" value="${c.id}">${c.name}
	</c:forEach>
	</br>
	<label>도서</label>
	</br>
	<c:forEach var="b" varStatus="i" items="${books}">
		<input type="radio" name="bookId" value="${b.id}">${b.title}(${b.price})
	</c:forEach>
	</br>
	<label>주문하기</label>
		<input type="number" name="sellingPrice" id="selling_price" data-role="input" data-prepend="판매가: " />
	<br>	
	<input type ="submit" value="주문" id="ordering_button"/>
	</br>
	</form>
	
	
	<label>주문</label>
	</br>

	<div id="orderingPage" class="container bg-primary">
		<table style="width: 100%",
                    >
			<thead>
				<tr>
					<th>고객번호</th>
					<th>고객명</th>
					<th>도서번호</th>
					<th>도서명</th>
					<th>도서가격</th>
					<th>주문날짜</th>
				</tr>
			</thead>
			
					<tbody id="orderingPageTb">
						<c:forEach var="o" varStatus="i" items="${orderings}">
					<tr>
						<th>${o.customerId}</th>
						<th><c:forEach var="c" varStatus="i" items="${customers}">
								<c:if test="${c.id == o.customerId}">
                   				 ${c.name}	
                    			</c:if>
							</c:forEach></th>
						<th>${o.bookId}</th>
						<th><c:forEach var="b" varStatus="i" items="${books}">
								<c:if test="${b.id == o.bookId }">
                    		${b.title}
                    			</c:if>
							</c:forEach></th>
						<th>${o.sellingPrice}</th>
						<th>${o.orderingDate}</th>
					</tr>
					</c:forEach>
				</tbody>
			

			<tbody id="orderingPageTb"></tbody>
		</table>
		<table id="userTableTbody"></table>
</body>
</html>