<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="spms.vo.Member" %>
<%
	Member member = (Member)session.getAttribute("member");
%>
<div style="background-color:#00008b; color:white; height:20px; padding: 5px">
	SPMS(Simple)
	<span style="float:right"><%=member.getName() %>
		<a style="color:white;" href="<%=request.getContextPath() %>/auth/logout">·Î±×¾Æ¿ô</a>
	</span>
</div>