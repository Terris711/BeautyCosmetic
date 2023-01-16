<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Success!!</h1>
Hello ${sessionScope.name}
<br>
<c:if test= "${sessionScope.name}!=null">
<a href="LogoutServlet">Logout</a>
</c:if>
<c:if test="${sessionScope.name}==null">
<a href="login.jsp">Back to Login Page</a>
</c:if>
</body>
</html>