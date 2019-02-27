<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
		<input type="submit" value="add" name="doThisToSource">
		<input type="submit" value="edit" name="doThisToSource"> 
		<input type="submit" value="delete" name="doThisToSource"> 		
		<input type="submit" value="view citations" name="doThisToSource">	
	</form><br>
</body>
</html>