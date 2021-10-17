<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Candy CRUD Operation</title>
</head>
<body>
	<h1>Add List details for ${name}</h1>
	<form action="SaveListData" method="post">
		<input type="hidden" name="shoperId" value="${id}"> <input
			type="hidden" name="id" value="0"> List Name: <input
			type="text" name="name"><br />
		<br /> Trip date: <input type="text" name="month" placeholder="mm"
			size="4"> <input type="text" name="day" placeholder="dd"
			size="4">, <input type="text" name="year" placeholder="yyyy"
			size="4"> <br />
		<br />Available Items:<br /> <select name="allItemsToAdd" multiple
			size="6">
			<c:forEach items="${requestScope.itemList}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.itemName}</option>
			</c:forEach>
		</select><br />
		<br /> <input type="submit" value="Save"> <br />
	</form>
	<br />
	<br />
	<br />
	<a href="ViewAllNameServlet">View the complete list</a>
</body>
</html>