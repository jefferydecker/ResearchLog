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

<h2> Citation </h2>
<form action = "EditCitationServlet" method="post">

	<input type="hidden" name="srcId" value="${ citationToEdit.srcId }">
	<input type="hidden" name="refId" value="${ citationToEdit.refId }">
	Reference (paraphrase, quote, etc): <input type ="text" name = "refBody" value="${refBody }"><br/>
	Date Found:
		<input type ="text" name = "month" value="${month}" placeholder="mm" size="4">
		<input type ="text" name = "day" value="${day }" placeholder="dd" size="4">,
		<input type ="text" name = "year" value="${year}" placeholder="yyyy" size="4"> <br />
	Location Details (pages, issue number, library): <input type = "text" value="${locDetail}" name="locDetail"><br />

<input type = "submit" value="Update Citation">
</form>
</body>
</html>