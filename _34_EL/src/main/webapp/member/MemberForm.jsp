<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 등록</title>
</head>
<body>
	<h1>회원 등록</h1>
	<form action='add' method='post'>
		이름 : <input type='text' name='name'><br>
		이메일 : <input type='text' name='email'><br>
		암호 : <input type='text' name='password'><br>
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
	</form>
</body>
</html>