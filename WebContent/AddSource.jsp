<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action = "AddSourceServlet" method="post">

	Title: <input type="text" name="srcTitle" value="${sourceToAdd.srcTitle}">
		Author: <input type="text" name="srcAuthor" value="${sourceToAdd.srcAuthor}">
		Publication: <input type="text" name="srcPublication" value="${sourceToAdd.srcPublication}">
		Location: <input type="text" name="srcLocation" value="${sourceToAdd.srcLocation}">
		<input type="hidden" name="srcId" value="${sourceToAdd.srcId}"> 
		<input type="submit" value="Save Edited Source">
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>