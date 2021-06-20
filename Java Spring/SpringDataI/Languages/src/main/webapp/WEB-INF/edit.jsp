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
        	<form action="/languages/${language.id}/edit" method="POST" >
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name">Name</label>     
                            <input type="text" name="name" placeholder="${language.name}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                             <label for="creator">creator</label>
                             <input type="text" name="creator" placeholder="${language.creator}">                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="version">Version</label>
                            <input type="text" name="version" placeholder="${language.version}">
                        </div>
                        <input type="submit" value="Submit"/>
                    </div>
         		</form>
        </div>

</body>
</html>