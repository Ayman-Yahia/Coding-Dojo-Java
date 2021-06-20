<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name}</title>
</head>
<body>
<a href="/languages/${language.id}/delete">Delete</a> <a href="/languages">Dashboard</a>
	<div class="lang">
        	<form:form action="/languages/${language.id}/edit" method="post" modelAttribute="language">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <form:label path="name">Name</form:label>     
                            <form:input path="name" placeholder="${language.name}"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                             <form:label path="creator">creator</form:label>
                             <form:input path="creator" placeholder="${language.creator}"/>                        </div>
                        <div class="col-md-6 mb-3">
                            <form:label path="version">Version</form:label>
                            <form:input path="version" placeholder="${language.version}"/>
                        </div>
                        <input type="submit" value="Submit"/>
                    </div>
         		</form:form>
        </div>

</body>
</html>