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
			<c:forEach items="${requestScope.allSources}" var="currentSource">
				<tr>
					<td><input type="radio" name="id" value="${currentSource.srcId}"></td>
					<td>${currentSource.srcTitle}</td>
					<td>${currentSource.srcAuthor}</td>
					<td>${currentSource.srcPublication}</td>
					<td>${currentSource.srcLocation}</td>
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