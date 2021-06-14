<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인</title>
	<script>
		setTimeout(function(){
			location.href='/ServerProgram1/selectMemberList.do';
		}, 0000);
	</script>
</head>
<body>
	<h1>회원목록</h1>
	<table border="1">
		<thead >
			<tr>
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.no}</td>
					<td>${dto.id}</td>
					<td>${dto.name}</td>
					<td>${dto.grade}</td>
					<td>${dto.point}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>