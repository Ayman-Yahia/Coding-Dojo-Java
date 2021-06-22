<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	<div id="container">
		<div id="leftpanelb">
			<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
			<p>License Number: <c:out value="${person.license.number}"/></p>
			<p>State: <c:out value="${person.license.state}"/></p>
			<p>Expiration Date: <c:out value="${person.license.expirationDate}"/></p>
		</div>
	</div>

</body>
</html>