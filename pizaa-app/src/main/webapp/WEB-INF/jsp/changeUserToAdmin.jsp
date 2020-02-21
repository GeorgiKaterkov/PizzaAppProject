<html>

<head>
<title>registerPage</title>
</head>

<body>

	<form method="post" action="changeUserToAdmin">
		<div>
			<h2 style="font-family: courier;" align="center">
			    Change role of user to admin				 
				</h2>
				<label><b>Username: </b></label> <input type="text" name="username">				
				<button type="submit" name="button">
					<b>CHANGE</b>
				</button>	
				<button onclick="redirect:/adminMenu">BACK</button>			
		</div>
	</form>

</body>
<style>
h2 {
	color: #00b300;
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
	border: 3px solid #00b300;
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