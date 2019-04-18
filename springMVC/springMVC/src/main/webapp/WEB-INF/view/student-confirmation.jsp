<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmed</title>
</head>
<body>

	Student ${student.firstName} ${student.lastName} from
	${student.country} is confirmed
	<br>
	<br> Your Favourite Language is ${ student.favouriteLanguage }
	<br>
	<br> You have experience in following Operating Systems
	<ul>
		<c:forEach var="temp" items="${ student.operatingSystems }">
			<li>${ temp }</li>
		</c:forEach>
	</ul>


</body>
</html>