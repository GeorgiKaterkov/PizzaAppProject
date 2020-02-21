<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>registerPage</title>
</head>

<body>

	<form action="processOrders" method="post">
		<table align="center">
			<tr>
				<th>New orders</th>
				<th></th>
			</tr>
			<c:forEach items="${orders}" var="order" varStatus="status">
				<tr>
					<td align="center">${order.user}</td>
					<td align="center">${order.date}</td>
				</tr>
			</c:forEach>
			<tr>
			<td align="center"><button onclick="processOrders">PROCESS</button></td>
			<td align="center"><button onclick="redirect:/adminMenu">BACK</button></td>
			</tr>
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
	background-color: #b30000;
	color: white;
}

table, th, td, button {
	border: 1px solid black;
	border-collapse: collapse;
	font-family: "Courier New", Courier, monospace;
}

table {
	width: 50%;
}

button {
	color: black;
	background-color: #a6a6a6;
	border-color: transparent;
}

</style>
</html>