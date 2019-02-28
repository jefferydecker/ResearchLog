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
<form method = "post" action = "SourceNavServlet">
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
<input type = "submit" value = "edit" name="doThisToSource">
<input type = "submit" value = "delete" name="doThisToSource">
<input type = "submit" value = "add" name = "doThisToSource">
</form>
<p>Note: Deleting a source will delete all of it's citations.</p>
<a href="ViewAllServlet">Show/Edit/Delete all entries (sources and citations)</a><br>
<a href="addSourceForCitationServlet">Add new Citation</a><br>
<a href="index.html">Home</a><br>

</body>
</html>