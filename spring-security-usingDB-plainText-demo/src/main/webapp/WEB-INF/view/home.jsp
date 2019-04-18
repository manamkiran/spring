<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to My Page</title>
</head>
<body>

	<h1>
		YO
		<security:authentication property="principal.username" />
		What's up
	</h1>
	You have below roles
	<br>

	<security:authentication property="principal.authorities" />

	<br>
	<%-- <security:authorize access="hasRole('${spring.security.demo.Roles.MANAGER}')"> --%>
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">LeadershipMeeting</a>
		<br>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/systems">Systems Page</a>
		<br>
	</security:authorize>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
		post="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>