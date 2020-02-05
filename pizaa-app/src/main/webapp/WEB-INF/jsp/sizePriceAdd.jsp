<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>
<head>

</head>

<body>
    
	<form:form method="post" action="/basket/addingPizza" modelAttribute="bean">
		<div>
			<h1 style="font-family: courier;" align="center">Choose size</h1>
			<form:select path="pizzaId">
                <form:option value="0" label="--Select pizza"/>
                <form:options  itemValue="pizzaId" itemLabel="name" items="${pizzaVariaty}" />
            </form:select>
			<label style="font-family: courier;"><b>Quantity</b></label> 
			<input type="number" name="quantity" min="1" max="5">
				
				<button type = "submit">ADD</button>
			
			<a href="userMenu">Back</a> 
		</div>
	</form:form>
</body>
<style>
h2 {
	color: #737373;
}

div {
	border-radius: 12px;
	margin: auto;
	width: 15%;
	border: #bfbfbf;
	padding: 30px;
	border-style: outset;
	background-color: #ffffff;
	background-image:
		url("https://transparenttextures.com/patterns/brick-wall.png");
}

button {
	margin: 8px;
	border-radius: 12px;
	padding: 8px 30px;
	background-color: #ffbf80;
	align: center;
	font-family: courier;
}

select {
	border: #bfbfbf;
	border-style: outset;
	font-family: courier;
	border-radius: 12px;
}

input {
	border: #bfbfbf;
	border-style: outset;
	font-family: courier;
	border-radius: 12px;
}
</style>

</html>