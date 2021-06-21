<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a><br>
   <p>Title: ${song.title}</p><br>
   <p>Artist: ${song.artist}</p><br>
   <p>Rating: ${song.rating}</p><br>
   <a href="/songs/${song.id}/delete">Delete</a>

</body>
</html>