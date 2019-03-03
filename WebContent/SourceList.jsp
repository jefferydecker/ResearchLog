<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sources</h1>
	<form method="post" action="SourceNavServlet">
		<table>
			<c:forEach items="${requestScope.allSources}" var="currentsource">
				<tr>
					<td><input type="radio" name="id" value="${currentsource.srcId}"></td>
					<td>${currentsource.srcTitle}</td>
					<td>${currentsource.srcAuthor}</td>
					<td>${currentsource.srcPublication}</td>
					<td>${currentsource.srcLocation}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="add source" name="doThisToSource">
		<input type="submit" value="edit source" name="doThisToSource"> 	
		<input type="submit" value="view source citations" name="doThisToSource">	
		<input type="submit" value="add new citation" name="doThisToSource">
	</form><br>
	
	<a href="index.html">Home</a>
	
</body>
</html>