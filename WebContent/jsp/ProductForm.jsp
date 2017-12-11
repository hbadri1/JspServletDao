<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add product</title>
<style type="text/css">
@import url(resources/css/main.css);
</style>
</head>
<body>
	<div id="global">
		<h3>Add a product</h3>
		<c:if test="${requestScope.errors != null}">
			<div id="errors">
				Errors!
				<ul>
					<c:forEach var="error" items="${requestScope.errors}">
						<li>${error }</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<form method="post" action="product_save">
			<table>
				<tr>
					<td>Product name:</td>
					<td><input type="text" name="name" value="${form.name}" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description"
						value="${form.description}" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="price" value="${form.price}" /></td>
				</tr>
				<tr>
					<td><input type="reset" /></td>
					<td><input type="submit" value="Add product" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>