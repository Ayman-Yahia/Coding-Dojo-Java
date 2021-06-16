<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
	<div class="container" style="margin-left:580px;margin-top:120px;">
		<!-- ... -->
		<form method="POST" action="/code">
		    <label>Your Name:</label> 
		    <input type="text" name="name" required>
		    <label>Dojo Location: </label> <select name="location" required>
		      <option value=""></option>
			  <option value="Nablus">Nablus</option>
			  <option value="Jenin">Jenin</option>
			  <option value="Ramallah">Ramallah</option>
			</select><br>
			
			<label>Favorite Language: </label> 
			<select name="language" required>
			  <option value="Java">Java</option>
			  <option value="Python">Python</option>
			  <option value="React">React</option>
			</select><br>
			<label>Comment (optional):</label> 
			<textarea name="comment"  placeholder=""  style="height: 100px; width: 450px;" ></textarea>
		    <button>Button</button>
		</form>
		<!-- ... -->
	</div>
</body>
</html>