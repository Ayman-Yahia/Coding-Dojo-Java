<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<div class="container" style="margin-left:300px;margin-top:150px">
		<h2>New Category</h2><br>
		<div class="product">
	        	<form:form action="/categories/new" method="post" modelAttribute="category">
	                    <div class="row">
	                        <div class="col-md-6 mb-3"> 
	                            <form:label path="name">Name: </form:label>    
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