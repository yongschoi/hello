<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: 사용자 정보</title>
</head>
<style>
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}
</style>
<body>
	<jsp:include page="../_menu.jsp" />
	<li>사용자명 : ${user.userName}</li>
	<br>
	<li>비밀번호 : ${user.password}</li>
	<br>
	| <%=  request.getSession(false).getId() %> |
</body>
</html>