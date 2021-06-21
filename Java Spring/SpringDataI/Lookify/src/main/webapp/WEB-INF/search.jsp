<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<p>Songs by artist : <c:out value="${artist}" /></p>
		<form class="d-flex" action="/search" method="GET">
        <input class="form-control me-2" type="search" placeholder="${searchWord}" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      	<a href="/dashboard">Dashboard</a>
      </form>
		</div>
		<div class="table-1">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Rating</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${artistsongs}" var="song">
                    <tr>
                        <td><a href="/songs/${song.id}">${song.title}</a></td>
                        <td>${song.rating}</td>
                        <td><a href="/songs/${song.id}/delete">Delete</a> </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
	</div>

</body>
</html>