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
	 <td><input type="radio" name="id" value="${currentsource.srcId}"></td>
	 <td><h4>${currentsource.srcTitle}</h4></td>
	 <td>${currentsource.srcAuthor}</td>
	 <td>${currentsource.srcPublication}</td>
	 <td>${currentsource.srcLocation}</td>
 	</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<!-- 
<input type = "submit" value = "add citation" name = "doThisToItem">
-->
</form>
<a href="AddSource.jsp">Add a new Source</a><br />
<a href="addSourceForCitationServlet">Add new Citation</a><br>
<a href="index.html">Home</a><br>

</body>
</html>