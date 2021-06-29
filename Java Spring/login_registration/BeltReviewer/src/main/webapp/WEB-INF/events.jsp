<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Events</title>
</head>
<body>
<div class="rigth">
<a href="/logout" class="btn btn-danger">Logout</a>
	<h1>Welcome, <c:out value="${user.firstName}"/></h1>
	<p>Here are some of the events in your location:</p>
	<table class="table table-striped">
		<thead>
			<th>Name</th>
			<th>Date</th>
			<th>City</th>
			<th>State</th>
			<th>Host</th>
			<th>Action/Status</th>
		</thead>
		<tbody>
			<c:forEach items="${in_states}" var="event">
			<tr>
				<td><c:out value="${event.eventName}"/></td>
				<td><c:out value="${event.eventDate}"/></td>
				<td><c:out value="${event.city}"/></td>
				<td><c:out value="${event.state}"/></td>
				<td><c:out value="${event.hostUser.firstName}"/></td>
				<c:choose>
					<c:when test="${myUserId==event.hostUser.id}">
						<td><a href="/events/edit/${event.id}">Edit</a> | <a href="/events/delete/${event.id}">Delete</a></td>
					</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${myUserId!=event.hostUser.id}">
							<td><a href="/events/join/${event.id}">Join</a> | <a href="/events/cancle/${event.id}">Cancel</a></td>
						</c:when>
					</c:choose>
				</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Here are some of the events in other locations:</p>
	<table class="table table-striped">
		<thead>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action/Status</th>
		</thead>
		<tbody>
			<c:forEach items="${not_states}" var="event">
			<tr>
				<td><c:out value="${event.eventName}"/></td>
				<td><c:out value="${event.eventDate}"/></td>
				<td><c:out value="${event.city}"/></td>
				<td><c:out value="${event.hostUser.firstName}"/></td>
				<td><a href="/events/${event.id}/join">Join</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Create an event</h2>
    		<form:form action="/event/add" method="post" modelAttribute="event">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Create Event</h2></td>
                </tr>
                <tr>
                    <td>Event Name:</td>
                    <td><form:input path="eventName" /></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><form:input type="date" path="eventDate" /></td>
                    <td><c:out value="${dateError}"/></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td><form:input path="city" /></td>
                    <td><form:select path="state" items="${states}" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Create Event" /></td>
                </tr>
            </table>
        </form:form>
   	</div>

</body>
</html>