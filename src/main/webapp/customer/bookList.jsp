<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookList</title>
</head>
<body>
	<div data-role="appbar" data-extend="true">
	 <ul class="app-bar-menu">
	  <li><a href='<c:url value="/mcontrol"/>'>주문</a></li>
	  <li><a href='<c:url value="/ccontrol"/>'>고객</a></li>
	  <li><a href='<c:url value="/mcontrol?action=books"/>'>도서</a></li>
	 </ul>
	
	</div>
	</br>
	</br>
	</br>
	<div class="container">
	 <label>도서</label>
	 </br>
	 <table class="table">
	  <thead>
	   <tr>
	    <th>도서번호</th>
	    <th>도서이름</th>
	    <th>도서가격</th>
	    <th>출판사</th>
	   </tr>
	   </thead>
	   <tbody id="books">
	   <c:forEach var="b" items="${books}">
	   <tr>
	    <th><a class="book_id" href="<c:url value="mcontrol?action=book&id=${b.id}"/>">${b.id}</a></th>
	    <th>${b.title}</th>
	    <th>${b.publisher}</th>
	    <th>${b.price}</th>
	   </tr>
	    </c:forEach>
	   </tbody>
	 </table>
	</div>
	
	<div class="container">
	 <form id="goto_form" action ="<c:url value="mcontrol"/>" method="get">
	  <input type="hidden" name="action" value="book"/>
	  <input type="hidden" name="id" value="-1"/>
	  <input type="submit" value="추가" id="add_button"/>
	 </form>
	</div>
	
	
	<script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>
	<script>
            let hasOrdering = ${hasOrdering};
           
        </script>
	<script src="books.js"></script>
</body>
</html>