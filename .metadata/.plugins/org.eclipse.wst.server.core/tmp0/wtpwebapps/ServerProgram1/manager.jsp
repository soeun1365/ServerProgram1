<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		*{
			padding: 0;
			maring: 0 auto;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	$(document).ready(function(){
		
		delete(){
			if(alert('탈퇴하시겠습니까?')){
					location.href='/ServerProgram1/delete.do';
			}
		}
	})
		
	</script>
</head>
<body>
	<h2>회원 관리 시스템</h2>
	<a href="">로그아웃</a>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="loginDTO">
					<tr>
						<td>${dto.id}</td>
						<td><input type="text" name="name" value="${dto.name}"></td>
						<td>${dto.grade}</td>
						<td><input type="text" name="point" value="${dto.point}"></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<input type="button" value="수정하기" id="update_btn">
				<input type="button" value="탈퇴하기" id="delete_btn" onclick="delete()">
			</tfoot>
	</table>
</body>
</html>