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
	<jsp:useBean id="member"
				scope="request"
				class="spms.vo.Member"
				type="spms.vo.Member"/>
				
	<form action='update' method='post'>
		��ȣ: <input type='text' name='no' value='<%=member.getNo() %>' readonly><br>
		�̸�: <input type='text' name='name' value='<%=member.getName() %>'><br>
		�̸���: <input type='text' name='email' value='<%=member.getEmail() %>'><br>
	������: <%=member.getCreateDate() %><br>
	<input type='submit' value='����'>
	<input type='button' value='����' "
			+ "onclick='location.href=\"delete?no=" + 
			req.getParameter("no") + "\";'>
	<input type='button' value='���'" + 
		" onclick='location.href=\"list\"'>
	</form>
</body>
</html>