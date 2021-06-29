<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
	<h1>Edit Event</h1>
	<form:form action="/events/edit/${mEvent.id}" method="post" modelAttribute="event">
	<input type="hidden" name="_method" value="put">
	   <table border="0">
                <tr>
                    <td>Event Name:</td>
                    <td><form:input path="eventName" /></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><form:input type="date"  path="eventDate" /></td>
                    <td><c:out value="${dateError}"/></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td><form:input path="city" /></td>
                    <td><form:select path="state" items="${states}" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Edit Event" /></td>
                </tr>
            </table>
	</form:form>

</body>
</html>