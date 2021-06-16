<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
</head>
<body>
 <div class="container" style="margin-left:580px;margin-top:120px;">
     <p><c:out value="${error}"/></p>
	 <!-- ... -->
	<form method="POST" action="/code">
	    <label>What is the Code? <input type="text" name="code"></label>
	    <button>Try Code</button>
	</form>
	<!-- ... -->
 </div>

</body>
</html>