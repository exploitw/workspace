<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%


Map<String,List<String>> firstMap = new HashMap<>();
firstMap.put("8구단 드래프트 1순위", Arrays.asList("몸 만들기","제구","구위","멘탈","스피드 160km/h","인간성","운","변화구"));

List<String> firstList = new ArrayList<>();
firstList.addAll(firstMap.get("8구단 드래프트 1순위"));
firstList.add(4, "8구단 드래프트 1순위");
pageContext.setAttribute("firstList",firstList);

Map<String,List<String>> secondMap = new HashMap<>();
for(String s : firstMap.get("8구단 드래프트 1순위")){
	secondMap.put(s, null);
}
secondMap.put("몸 만들기", Arrays.asList("몸 관리","영양제 먹기","FSQ 90kg","RSQ 130kg","유연성","스테미너","가동역","식사 저녁7숙갈 아침3숟갈"));
secondMap.put("제구", Arrays.asList("인스텝 개선","몸통 강화","축 흔들지 않기","불안정 없애기","멘탈을 컨트롤","몸을 열지 않기","하체 강화","릴리즈 포인트 안정"));
secondMap.put("구위", Arrays.asList("각도를 만든다","위에서부터 공을던진다","손목 강화","힘 모으그","하반신주도","볼을앞에서릴리즈","회전수 증가","기동력"));
secondMap.put("멘탈", Arrays.asList("뚜렷한목표목적","핀치에강하게","마음의파도를안만들기","승리에대한집념","동료를배려하는마음","분위기에 휩쓸리지않기","머리는차갑게심장은뜨겁게","일희일비하지않기"));
secondMap.put("스피드 160km/h", Arrays.asList("축을돌리기","몸통 강화","가동력","라이너 캐치볼","피칭늘리기","어깨주변강화","체중증가","하체강화"));
secondMap.put("인간성", Arrays.asList("감성","배려","예의","신뢰받는사람","지속력","감사","계획성","사랑받는사람"));
secondMap.put("운", Arrays.asList("인사하기","물건을 소중히 쓰자","긍정적 사고","응원받는 사람","책일기","심판을 대하는태도","부실청소","쓰레기 줍기"));
secondMap.put("변화구", Arrays.asList("카운트볼늘리기","늦게 낙차가있는 커브","직구와 같은폼으로 던지기","스트라이크볼을 던질떼 제구","거리를 상상하기","좌타자결정구","슬라이더구위","포크볼 완성"));

//request.serCharcterEncoding("UTF-8"); post방식이면 이 코드를 붙여야 한다.
String goal =request.getParameter("goal");

List<String> secondList = new ArrayList<>();
if(goal != null){
	secondList.addAll(secondMap.get(goal));
	secondList.add(4, goal);
	
}
pageContext.setAttribute("goal",goal);
pageContext.setAttribute("secondList",secondList);






 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Mandalaart.jsp" method="get">
	<table border="1">
		<c:forEach begin="0" end="2" step="1" varStatus="i">
			<tr>
			<c:forEach begin="0" end="2" step="1" varStatus="j">
				<%-- <c:choose>
				<c:when test="${3*i.index+j.index ==4}">
				<td>${firstList[3 * i.index + j.index ]}</td>
				</c:when>
				<c:otherwise>
				 <td><input type="submit" name= "goal" value="${firstList[3 * i.index + j.index]}"></td>
				</c:otherwise>
				</c:choose> --%>
				 <c:if test="${3 * i.index + j.index ==4}">
				 <td>${firstList[3 * i.index + j.index ]}</td>
				</c:if>
				<c:if test="${3 * i.index + j.index !=4}">
				 <td><input type="submit" name= "goal" value="${firstList[3 * i.index + j.index]}"></td>
				</c:if> 
			</c:forEach>
			</tr>
		</c:forEach>
		</table>
		</form>
			<c:if test="${!empty goal}">
			<table border="1">
			<c:forEach begin="0" end="2" step="1" varStatus="i">
			<tr>
			<c:forEach begin="0" end="2" step="1" varStatus="j">
			<td>${secondList[3 * i.index + j.index]}</td>
			</c:forEach>
			</c:forEach>
			</c:if>
			</tr>
	
	
		<%-- <table border="1">
		<%for(int i = 0; i < 3; i++) { %>
		<tr>
		<%for(int j = 0; j <3; j++){ %>
		<%if(3 * i + j ==4){ %>
		<td><%= firstList.get(3 * i + j ) %></td>
		<% }else{ %>
		<td><input type="submit" name= "goal" value="<%= firstList.get(3 * i + j)%>"></td>
		<%} %>
		<%} %>
		</tr>
		<%} %>
		</table>
	</form>
		<%if (goal != null){ %>
		<table border="1">
		<%for(int i = 0; i < 3; i++) { %>
		<tr>
		<%for(int j = 0; j <3; j++){ %>
		
		<td><%= secondList.get(3 * i + j ) %></td>
		<% } %>
		
		<%} %>
		<%} %>
		</tr>
		 --%>
		</table>
	
	
	
	
	
</body>
</html>