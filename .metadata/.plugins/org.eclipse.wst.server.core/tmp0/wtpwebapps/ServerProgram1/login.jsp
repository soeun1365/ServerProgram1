<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<style>
		*{
			padding: 0;
			margin: 0 auto;
		}
		h2{
			margin-top: 100px;
			text-align: center;
		}
		form, input{
			width: 200px;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			const f = $('#f');
			const id = $('#id');
			const name = $('#name');
			
			f.submit(function(event){
				if (id.val() == '' || name.val() == '') {
					alert('아이디와 이름은 필수입니다.');
					event.preventDefault();
					return false;
				}
			})	
		})
		
		
	</script>
</head>
<body>

	<h2>회원 관리 프로그램</h2><br>
	
	<form id="f" action="/ServerProgram1/loginCommand.do" method="post">
		<input type="text" id="id" name="id" placeholder="아이디"><br>
		<input type="text" id="name" name="name" placeholder="이름"><br>
		<br>
		<button>로그인</button>
		<a href="/ServerProgram1/join.jsp">회원가입</a>
	</form>
</body>
</html>