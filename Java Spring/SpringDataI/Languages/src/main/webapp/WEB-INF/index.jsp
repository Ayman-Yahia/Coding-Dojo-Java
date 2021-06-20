<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Languages</title>
</head>
<body>
   <div class="container con">
        <h3 class="jumbotron-heading">All Languages</h3>
        <div class="table-1">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Creator</th>
                        <th scope="col">Version</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${languages}" var="language">
                    <tr>
                        <td>${language.name}</td>
                        <td>${language.creator}</td>
                        <td>${language.version}</td>
                        <td><a href="/languages/${language.id}/delete">Delete</a> <a href="/languages/${language.id}/edit">edit</a> </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="lang">
        	<form:form action="/languages/new" method="post" modelAttribute="language">
                    <div class="row">
                        <div class="col-md-6 mb-3">     
                            <form:input path="name" placeholder="Name"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                             <form:input path="creator" placeholder="Creator"/>                        </div>
                             <form:errors path="creator"/>
                        <div class="col-md-6 mb-3">
                            <form:input path="version" placeholder="Version"/>
                            <form:errors path="version"/>
                        </div>
                        <input type="submit" value="Submit"/>
                    </div>
         		</form:form>
        </div>
    </div>

</body>
</html>