<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Child1</title>
</head>
<body>
	<form  action = "canride.jsp" method="post">
	나이:<input type="text" name="age">
	키:<input type="text" name="height">
	부모동반:<input type="checkbox" name="withparent" value="true">
	심장병:
		유 <input type="radio" name="heartDisease" value="true">
		무 <input type="radio" name="heartDisease" value="false" checked>
	선호 놀이 기구:
		롤러코스터 <input type="checkbox" name="attractions" value="rollercoaster" >
		범퍼카 <input type="checkbox" name="attractions" value="bumpercar">
		회전목마 <input type="checkbox" name="attractions" value="marrygoround">
		  <input type="submit"> 
		<!--  <input type="button" name="제출" value="제출" onclick="canRide();">  -->
		</form>
	
	<!-- <script>
	function canRide(){
		document.forms['canride'].action = document.forms['canride'].attractions.value + '.jsp';
		document.forms['canride'].submit();
	}
	
	</script> -->
	</body>
</html>