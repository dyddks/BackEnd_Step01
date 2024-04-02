<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="spms.vo.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원정보</title>
</head>
<body>
	<h1>회원정보</h1>
				
	<form action='update' method='post'>
		번호: <input type='text' name='no' value='${member.no }' readonly><br>
		이름: <input type='text' name='name' value='${member.name }'><br>
		이메일: <input type='text' name='email' value='${member.email }'><br>
	가입일: ${member.createDate }<br>
	<input type='submit' value='저장'>
	<input type='button' value='삭제' "
			+ "onclick='location.href=\"delete?no=" + 
			${member.no } + "\";'>
	<input type='button' value='취소'" + 
		" onclick='location.href=\"list\"'>
	</form>
</body>
</html>