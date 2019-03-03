<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<body>
<h1>Citations</h1>
	<form method="post" action="CitationNavServlet">	
		<h2> "${srcTitle}"</h2>
		<table>
			<c:forEach items="${requestScope.citationList}" var="currentcitation">
				<tr>
					<td><input type="radio" name="id" value="${currentcitation.refId}"></td>
					
					<td>${currentcitation.dateFound}</td>
					<td>${currentcitation.refBody}</td>
					<td>${currentcitation.locDetail}</td>
				<td>${currentcitation.srcId}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="add" name="doThisToCitation">
		<input type="submit" value="edit" name="doThisToCitation"> 
		<input type="submit" value="delete" name="doThisToCitation"> 
	</form><br>
	<a href="index.html">Home</a>
</body>
</html>