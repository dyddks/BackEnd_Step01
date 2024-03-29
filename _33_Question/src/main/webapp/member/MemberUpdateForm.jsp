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
	<jsp:useBean id="member"
				scope="request"
				class="spms.vo.Member"
				type="spms.vo.Member"/>
				
	<form action='update' method='post'>
		번호: <input type='text' name='no' value='<%=member.getNo() %>' readonly><br>
		이름: <input type='text' name='name' value='<%=member.getName() %>'><br>
		이메일: <input type='text' name='email' value='<%=member.getEmail() %>'><br>
	가입일: <%=member.getCreateDate() %><br>
	<input type='submit' value='저장'>
	<input type='button' value='삭제' "
			+ "onclick='location.href=\"delete?no=" + 
			req.getParameter("no") + "\";'>
	<input type='button' value='취소'" + 
		" onclick='location.href=\"list\"'>
	</form>
</body>
</html>