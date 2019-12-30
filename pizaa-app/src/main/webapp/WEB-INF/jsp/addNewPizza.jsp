<html>
<head>
<title>registerPage</title>
</head>

<body>

	<form action = "addNewPizza" method="post">
		<div>
			<h2 style="font-family: courier;" align="center">
				Add new pizza
				</h1>
				<label><b>Enter name: </b></label> 
				<input type="text" name="pizzaName">
				
				<input type="radio" name="size" value="small" > Small<br>
                <input type="radio" name="size" value="medium"> Medium<br>
                <input type="radio" name="size" value="large"> Large<br>
                
				<label><b>Enter price: </b></label>
				<input type="number" name="price" step="any">
				
				<button type="submit" name="button">
					<b>CREATE</b>
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