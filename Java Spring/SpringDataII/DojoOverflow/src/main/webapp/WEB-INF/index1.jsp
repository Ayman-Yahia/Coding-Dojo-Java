<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>New Question</title>
</head>
<body>
	<div class="container">
		<h2>New Question</h2>
		<div class="question">
        	<form:form action="/questions/new" method="post" modelAttribute="question">
                    <div class="row">
                        <div class="col-md-6 mb-3"> 
                            <form:label path="questionText">Question: </form:label>    
                            <form:textarea path="questionText" />
                            <form:errors path="questionText"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3"> 
                            <form:label path="tagName">Tags: </form:label>    
                            <form:input path="tagName" />
                            <form:errors path="tagName"/>
                        </div>
                    </div>
                        <input type="submit" value="Create"/>
                    </div>
			</form:form>
		</div>
	</div>

</body>
</html>