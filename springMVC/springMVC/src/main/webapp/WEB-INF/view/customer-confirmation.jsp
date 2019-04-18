<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Successful</title>
</head>
<body>

	${ customer.firstName } ${ customer.lastName } from PostalCode
	${customer.postalCode } has registered for Course <b>${ customer.courseCode }</b> 
	<br>
	<br> You have booked ${ customer.freePasses } free passes

</body>
</html>