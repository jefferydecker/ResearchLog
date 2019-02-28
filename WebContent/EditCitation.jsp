<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Citation</title>
</head>
<body>
<h3>Add Citation</h3><br>
<form action = "EditCitationServlet" method="post">
Available Sources: 
	<select name="allSources">
		<c:forEach items="${requestScope.allSources}" var="currentsource">
		 <option value = "${currentsource.srcId}">
		 ${currentsource.srcTitle} |
		 ${currentsource.srcLocation}
		 </option>
		</c:forEach>
	</select> <br />
	Reference (paraphrase, quote, etc): <input type ="text" name = "refBody"><br />
	Date Found:
		<input type ="text" name = "month" placeholder="mm" size="4">
		<input type ="text" name = "day" placeholder="dd" size="4">,
		<input type ="text" name = "year" placeholder="yyyy" size="4"> <br />
	Location Details (pages, issue number, library): <input type = "text" name = "locDetail"><br />

<input type = "submit" value="Save new citation">
</form>
<a href = "ViewAllServlet">Back to full listing.</a>
</body>
</html>