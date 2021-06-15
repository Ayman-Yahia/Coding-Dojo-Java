<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<link rel="stylesheet" href="css/style.css">
<script src="js/app.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.time').hover(function(){
                alert("This is the time template!")         
            })

        })
    </script>
<title>Time</title>
</head>
<body>
    <div class="container">
		<h1 class="time"><c:out value="${time}"/></h1>
	</div>

</body>
</html>