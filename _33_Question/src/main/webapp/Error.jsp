<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Exception error = (Exception)request.getAttribute("error");
		String err = error.getMessage();
	%>
	<p>Error: <%=err %></p>
	<p>
		요청을 처리하는 중에 문제가 발생하였습니다.<br>
		잠시후에 다시 요청 부탁드립니다.<br>
		계속 문제가 생긴다면 시스템 운영팀(02-1111-2222)에 연락하시기 바랍니다.
	</p>
</body>
</html>