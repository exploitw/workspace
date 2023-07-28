package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class todoapp2
 */
@WebServlet("/todoapp2")
public class todoapp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public todoapp2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =response.getWriter();
		String yyyy_MM_dd = java.time.LocalTime.now().toString();
		String html = htmlTemplate.replace(":yyyy-MM-dd:",yyyy_MM_dd);
		out.append();
				String html="""
				<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<title>실습 3-2</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 
 <script>
 function addItem(){
	 let todo = document.getElementById("item");
	 let list = document.getElementById("todolist");
	 let listitem = document.createElement("li");
	 
	 let input = document.createElement("input");
	 input.type = "checkbox";
	 input.Name ="checkedBox"
	 
	 listitem.className = "d-flex list-group-item list-group-item-action list-group-item-warning";
	 let xbtn = document.createElement("button");
	 
	 xbtn.className = "btn-close  ms-auto";
	 
	 xbtn.onclick = function(e){
		 let pnode = e.target.parentNode;
		 list.removeChild(pnode);
	 }
	 
	 listitem.innerText = todo.value;
	 listitem.appendChild(input);
	 listitem.appendChild(xbtn);
	 list.appendChild(listitem);
	 
	 todo.value = "";
	 todo.focus();
 }
 
 function deleteItem(){
	 /*
	let checkboxes = document.querySelectorAll('[type="checkbox"]');
	for(let checkbox of checkboxes){
		if(checkbox.checked){
			todolist.removeChild(checkbox.parentNode);
		}
	}
	let checkboxes = document.querySelectorAll('[type="checkbox"]:checked')
	for(let checkbox of checkboxes){
		todolist.removeChild(checkbox.parentNode);
	}	
	
	
	
 }
 </script>
 
</head>
<body>
	<div class="container bg-warning shadow mx-auto mt-5 p-5 w-75">
	<h2>My ToDo App:yyyy-MM-dd:</h2>
	<hr>
	<div class="input-group">
	<input id="item" class = "form-control"type="text" placeholder="할일을 입력하세요..">
	<button type="button" class= "btn btn-primary" onclick="addItem()">할일 추가</button>
	<button type="button" class= "btn btn-primary1" onclick="deleteItem()">완료된 일 삭제</button>
	
	</div>
	<hr>
	<ul id="todolist" class="list-group"></ul>
	</div>
	
</body>
</html>
				""";*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
