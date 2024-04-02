<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="spms.vo.Member" %>

<jsp:useBean id="member"
			scope="session"
			class="spms.vo.Member"></jsp:useBean>


<div style="background-color:#00008b; color:white; height:20px; padding: 5px">
	SPMS(Simple)
	
	<% if(member.getEmail() != null){ %>
	
	<span style="float:right"><%=member.getName() %>
		<a style="color:white;" href="<%=request.getContextPath() %>/auth/logout">·Î±×¾Æ¿ô</a>
	</span>
	<%} %>
</div>