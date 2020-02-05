<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>
<head>

</head>
<body>
	<form:form method="post" action="/sauceChoice" modelAttribute="bean">
		<table align="center">
			<tr>
				<th>Name/Price</th>				
				<th>Quantity</th>
				<th>Choice</th>
			</tr>
			<tr>
				<td><form:select path="id">
					<form:option value="0" label="--Select sauce" />
					<form:options itemValue="sauceId" itemLabel="name" items="${sauceVariaty}"/>						
				</form:select>
				</td>
				<td>
				<input type="number" name="quantity" min="1" max="5">
				</td>
				<td>
				<button type = "submit">ADD</button>
				</td>
			</tr>

		</table>
	</form:form>
</body>
<style>
table tr:nth-child(even) {
	background-color: #eee;
}

table tr:nth-child(odd) {
	background-color: #d9d9d9;
}

table th {
	background-color: #ffcc00;
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