<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>

<body>
	<div>
		<form:form method="post" action="/basketCart" modelAttribute="bean">
			<h1 style="font-family: courier;" align="center">Shopping cart</h1>
			<table>
				<tr>
					<th>Pizzas</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Size</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${pizzas}" var="pizza" varStatus="status">
					<tr>
						<td align="center">${pizza.namePizza}</td>
						<td align="center">${pizza.pizzaSize}</td>
						<td align="center">${pizza.price}lv</td>
						<td align="center">${pizza.quantity}</td>
					</tr>
				</c:forEach>
			</table>

			<table>
				<tr>
					<th>Sauces</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${sauces}" var="sauce" varStatus="status">
					<tr>
						<td align="center">${sauce.sauceName}</td>
						<td align="center">${sauce.price}lv</td>
						<td align="center">${sauce.quantity}</td>
					</tr>
				</c:forEach>
			</table>

			<table>
				<tr>
					<th>Drinks</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${drinks}" var="drink" varStatus="status">
					<tr>
						<td align="center">${drink.drinkName}</td>
						<td align="center">${drink.price}lv</td>
						<td align="center">${drink.quantity}</td>
					</tr>
				</c:forEach>
			</table>

			<p>Total price: ${sum}lv</p>
			<p>User ID: ${loggedUser}</p>
			<a href="/userMenu">Back</a>

			<c:choose>
				<c:when test="${not empty pizzas}">                   
                   <button>SUBMIT</button>
                </c:when>
                <c:when test="${not empty sauces}">                   
                   <button>SUBMIT</button>
                </c:when>
                <c:when test="${not empty drinks}">                   
                   <button>SUBMIT</button>
                </c:when>
				<c:otherwise>
					<p>Shopping cart is empty</p>
				</c:otherwise>
			</c:choose>
		</form:form>
	</div>
</body>
<style>
div {
	margin: auto;
	width: 25%;
	border: 3px solid #cccccc;
	padding: 10px;
	background-color: #ffffff;
	border-style: outset;
}

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
	width: 27%;
	margin: 6px;
	align: center;
}

input {
	border-color: transparent;
}
</style>

</html>