<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="spms.vo.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>
	<h1>ȸ������</h1>
				
	<form action='update' method='post'>
		��ȣ: <input type='text' name='no' value='${member.no }' readonly><br>
		�̸�: <input type='text' name='name' value='${member.name }'><br>
		�̸���: <input type='text' name='email' value='${member.email }'><br>
	������: ${member.createDate }<br>
	<input type='submit' value='����'>
	<input type='button' value='����' "
			+ "onclick='location.href=\"delete?no=" + 
			${member.no } + "\";'>
	<input type='button' value='���'" + 
		" onclick='location.href=\"list\"'>
	</form>
</body>
</html>