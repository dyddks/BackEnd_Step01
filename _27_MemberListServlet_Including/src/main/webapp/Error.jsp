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
		��û�� ó���ϴ� �߿� ������ �߻��Ͽ����ϴ�.<br>
		����Ŀ� �ٽ� ��û ��Ź�帳�ϴ�.<br>
		��� ������ ����ٸ� �ý��� ���(02-1111-2222)�� �����Ͻñ� �ٶ��ϴ�.
	</p>
</body>
</html>