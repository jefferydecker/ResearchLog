<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Citation by Source List</title>
</head>
<body>
<form method = "post" action = "">
<table>
<c:forEach items="${requestScope.allSources}" var="currentsource">
	
	<tr>
	 <td><h4>-></h4></td>
	 <td><h4>${currentsource.srcTitle}</h4></td>
	 <td>${currentsource.srcAuthor}</td>
	 <td>${currentsource.srcPublication}</td>
	 <td>${currentsource.srcLocation}</td>
 	</tr>
	 <c:forEach items = "${currentsource.citationList}" var = "currentcitation">
		 <tr><td><input type="radio" name="id" value="${currentcitation.refId}"></td>
		 	<td>${currentcitation.refBody}</td>
			<td>${currentcitation.dateFound}</td>
			<td>${currentcitation.locDetail}</td>
		 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToCitation">
<input type = "submit" value = "delete" name="doThisToCitation">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="viewAllSourcesServlet">Show/Edit Sources</a><br>
<a href="AddSource.jsp">Add a new Source</a><br>
<a href="index.html">Home</a><br>
</body>
</html>