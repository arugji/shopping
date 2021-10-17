<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoppers Details</title>
</head>
<body>
	<h1>Add Shopper Details</h1>
	<form action="SaveData" method="post">
		<input type="hidden" name="id" value="0"> Name: <input
			type="text" name="name"> <input type="submit" value="Save">
		<br />
	</form>
	<br />
	<br />
	<br />
	<a href="ViewAllNameServlet">View the complete list</a>
</body>
</html>