<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookInfo</title>
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
	<%-- <form id="book_form" action="<c:url value="mcontrol"/>" method="post"> --%>
	<form action="/jwbook/bookservlet?action=insert" method="post" id = "book_form">
		<input type="hidden" name="action" id="book_form_action"/>
		<div class="row">
                    <label class="cell-2">도서번호</label>
                    <div class="cell-10"><input type="number" data-role="input" name="id" value="${book.id}" id="id" readonly /></div>
                </div>
                <div class="row">
                    <label class="cell-2">도서이름</label>
                    <div class="cell-10"><input type="text" data-role="input" name="title" value="${book.title}" id="title" /></div>
                </div>
                <div class="row">
                    <label class="cell-2">출판사</label>
                    <div class="cell-10"><input type="text" data-role="input" name="publisher" value="${book.publisher}" id="publisher" /></div>
                </div>
                <div class="row">
                    <label class="cell-2">도서가격</label>
                    <div class="cell-10"><input type="number" data-role="input" name="price" value="${book.price}" id="price" /></div>
                </div>
                
                <div class="row">
                    <div class="cell-3"></div>
                    <div class="cell-3">
                        <button class="button" id="update_button">저장</button>
                        <button class="button" id="delete_button">삭제</button>
                    </div>
                    <div class="cell-3"></div>
                    <div class="cell-3"></div>
                </div>
            </form>
        </div>

        <script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>
	
		<script src="book.js"></script>
</body>
</html>