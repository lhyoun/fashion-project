<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
loginForm
</h1>
<hr>
<form action="/loginProc" method="post">
	<input type="text" name="username"/>
	<input type="text" name="password"/>
	<!-- input의 name은 저렇게 고정, method도 post -->
	<button>로그인</button>
</form>
</body>
</html>