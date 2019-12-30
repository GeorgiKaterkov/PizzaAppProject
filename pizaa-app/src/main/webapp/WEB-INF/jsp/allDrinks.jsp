<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
	<form method="post">
		<table align="center">
			<tr>
				<th>Name</th>				
				<th>Price</th>
				<th>Quantity</th>
				<th>Choice</th>
			</tr>
			<c:forEach items="${drinks}" var="drink" varStatus="status">
				<tr>
					<td align="center">${drink.drinkName}</td>					
					<td align="center">${drink.price}</td>
					<td align="center"><input type="number" name="quantity"
						min="1" max="5"></td>
					<input type="hidden" id="drinkId" name="drinkId"
						value="${drink.id}">
					<td align="center"><button type="submit">ADD</button></td>
				</tr>
			</c:forEach>
			<td align="center" bgcolor="#26734d"><button onclick="redirect:userMenu">BACK TO MENU</button></td>			
		</table>
	</form>
</body>
<style>
table tr:nth-child(even) {
	background-color: #eee;
}

table tr:nth-child(odd) {
	background-color: #d9d9d9;
}

table th {
	background-color: #26734d	;
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

button {
	color: black;
	background-color: #a6a6a6;
	border-color: transparent;
}

input {
	border-color: transparent;
}
</style>
</html>