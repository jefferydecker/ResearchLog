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
<c:forEach items="${requestScope.allItems}" var="currentsource">
<tr>
 <td><input type="radio" name="id" value="${currentsource.id}"></td>
 <td><h2>${currentsource.title}</h2></td>
 <td>${currentsource.author}</td>
 <td>${currentsource.srcloc}</td></tr>
 <tr><td colspan="3">Trip Date: ${currentsource.tripDate}</td></tr>
 <tr><td colspan="3">Shopper:
${currentsource.shopper.shopperName}</td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listOfItems}">
 <tr><td></td><td colspan="3">
 ${listVal.store}, ${listVal.item}
 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addItemsForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>
</html>