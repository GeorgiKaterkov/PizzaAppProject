<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<form action = "chooseSauceToUpdate" method="post">
		<div>
			<h2 style="font-family: courier;" align="center">
				Update sauce
				</h2>
				
				<c:forEach items="${sauces}" var="sauce" varStatus="status">
				
				<input type="radio" name="id" value="${sauce.id}"><br>${sauce.sauceName} / ${sauce.price}<br>  				
				</c:forEach>
				<input type="number" name="price" step="any">
				<button type="submit" name="button">
					<b>UPDATE</b>
				</button>				
		</div>
	</form>

</body>
<style>

h2 {
	color: #ff3333;
}

label {
	color: #bfbfbf;
	font-family: courier;
	align: center;
}

input {
	border-radius: 12px;
	border-style: solid;
	border-color: #d9d9d9;
	display: flex;
	align: center;
	justify-content: center;
	font-family: courier;
	background-color: #ffffff;
	border-style: outset;
}

div {
	border-radius: 15px;
	margin: auto;
	width: 15%;
	border: 3px solid #ff3333;
	padding: 10px;
	background-color: #ffffff;
	font-family: courier;
	border-style: outset;
	background-color: #ffffff;
	background-image:
		url("https://www.transparenttextures.com/patterns/brick-wall.png");
}

button {
	border-radius: 12px;
	padding: 11px 62px;
	background-color: #ffbf80;
	align: center;
	font-family: courier;
}


</style>
</html>