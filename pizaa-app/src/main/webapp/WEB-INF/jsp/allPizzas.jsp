<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>

</head>

<body>
	<form method="post" action="#">
		<table align="center">
			<tr>
				<th>Name</th>				
				<th>     </th>
			</tr>
			<c:forEach items="${pizzas}" var="pizza" varStatus="status">
				<tr>
					<td align="center">${pizza.namePizza}</td>			
					
					<td align="center">
					<c:url value="/basket/pizza" var="addToBasketUrl">
						<c:param name="namePizza"  value="${pizza.namePizza}"/>	
						</c:url>
					<a href='<c:out value="${addToBasketUrl}"/>' type="submit">ENTER</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
<style>

a {
  color: black;
}

table tr:nth-child(even) {
	background-color: #eee;
}

table tr:nth-child(odd) {
	background-color: #d9d9d9;
}

table th {
	background-color: #b30000;
	color: white;
}

table, th, td, button {
	border: 1px solid black;
	border-collapse: collapse;
	font-family: "Courier New", Courier, monospace;
}

table {
	width: 25%;
}

input {
	border-color: transparent;
}
</style>

</html>