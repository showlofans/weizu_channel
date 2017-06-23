<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--通过对session中登陆信息的判断，看是否需要返回登陆页面 -->
	<c:choose>
		<c:when test="${empty loginContext }">
			<jsp:forward page="WEB-INF/jsp/agency/login_page.jsp"></jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="WEB-INF/jsp/index.jsp"></jsp:forward>
		</c:otherwise>
	</c:choose>
</body>
</html>