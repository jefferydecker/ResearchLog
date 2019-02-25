<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Source Editor</title>
</head>
<body>
<form action="EditSourceServlet" method="post">
		Title: <input type="text" name="srcTitle" value="${sourceToEdit.srcTitle}">
		Author: <input type="text" name="srcAuthor" value="${sourceToEdit.srcAuthor}">
		Publication: <input type="text" name="srcPublication" value="${sourceToEdit.srcPublication}">
		Location: <input type="text" name="srcLocation" value="${sourceToEdit.srcLocation}">
		<input type="hidden" name="srcId" value="${sourceToEdit.srcId}"> 
		<input type="submit" value="Save Edited Source">
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>