<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h3>My Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		
		<c:if test="${param.error !=null}">
			<i style="color : red">Sorry! You entered invalid username/password</i>
		</c:if>

		<p>
			User Name: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>

		<input type="submit" value="Login" />
	</form:form>
</body>
</html>