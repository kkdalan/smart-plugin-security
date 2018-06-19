<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<html>
<head>
<title>首頁</title>
</head>
<body>
	<h1>首頁</h1>

	<shiro:guest>
		<p>身分:遊客</p>
		<a href="<c:url value="/login"/>">登陸</a>
		<a href="<c:url value="/register"/>">註冊</a>
	</shiro:guest>

	<shiro:guest>
		<p>身分:<shiro:principal/></p>
		<a href="<c:url value="/space"/>">空間</a>
		<a href="<c:url value="/logout"/>">登出</a>
	</shiro:guest>

</body>
</html>