<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Current visit count</title>
</head>
<body>
   <div class="container" style="margin-left:580px;margin-top:120px;">
   <p>you have visited <a href="/your_server">http://your_server</a></p>
   <h1><c:out value="${counter}"/></h1>
   </div>

</body>
</html>