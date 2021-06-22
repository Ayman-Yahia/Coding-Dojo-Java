<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>New License </title>
</head>
<body>
	<div id="container">
		<div id="leftpanel">
			<h1>New License</h1>
			<form:form action="/license/new" method="post" modelAttribute="license">
				<h2>
			        <form:label cssClass="label left" path="person">Person:</form:label>
			        <form:select cssClass="box" path="person">
						<c:forEach items="${peoplelist}" var="person">
							<form:option value="${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></form:option>
						</c:forEach>
					</form:select>
			    </h2>	  
			    <h2>
			        <form:label cssClass="label left" path="state">State:</form:label>
    			    <form:input cssClass="box" path="state"/>
			    </h2>
			    <h2>
			        <form:label cssClass="label left" path="expirationDate">Expiration Date:</form:label>
			        <form:input cssClass="box" type="date" path="expirationDate"/>
			    </h2>
			    <input id="btn" type="submit" value="Create"/>	 
			</form:form>
		</div>
	</div>

</body>
</html>