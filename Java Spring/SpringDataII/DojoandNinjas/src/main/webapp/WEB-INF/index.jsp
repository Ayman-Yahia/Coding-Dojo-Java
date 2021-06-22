<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>New Dojo</title>
</head>
<body>
	<div class="container">
		<div class="lang">
	        	<form:form action="/dojos/new" method="post" modelAttribute="dojo">
	                    <div class="row">
	                        <div class="col-md-6 mb-3"> 
	                            <form:label path="name">Name</form:label>    
	                            <form:input path="name" />
	                            <form:errors path="name"/>
	                        </div>
	                    </div>
	                        <input type="submit" value="Create"/>
	                    </div>
				</form:form>
	       </div>
    </div>

</body>
</html>