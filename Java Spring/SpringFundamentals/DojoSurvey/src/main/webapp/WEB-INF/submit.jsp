<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Info</title>
</head>
<body>
	<div class="container" style="margin-left:580px;margin-top:120px; background-color:red;">
	<p>Name:  <c:out value="${name}"/></p><br>
	<p>Dojo Location:  <c:out value="${location}"/></p><br>
	<p>Favorite Language:  <c:out value="${language}"/></p><br>
	<p>Comment:  <c:out value="${comment}"/></p><br>
	</div>

</body>
</html>