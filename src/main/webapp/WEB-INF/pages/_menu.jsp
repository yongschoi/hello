<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<style>
a:link {
    text-decoration: none;
}

a:visited {
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

a:active {
    text-decoration: underline;
}
	</style>
</head>
<body>

<div style="border: 1px solid #f1f1f1;padding:5px;margin-bottom:20px;background-color:#4CAF50;">
	&nbsp;
   <a href="${pageContext.request.contextPath}/hello">hello</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/user/retrieve?userNameParam=${sessionScope.SESSION_USER.userName}">본인정보확인</a>
  | &nbsp;
   <a href="${pageContext.request.contextPath}/logout">Logout</a>
	&nbsp;
</div>     
</body>
</html>
