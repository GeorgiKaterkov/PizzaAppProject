
<html>

<head>
<title>registerPage</title>
</head>

<body>

	<form method="post" action="/loginPage">
		<div>
			<h2 style="font-family: courier;" align="center">
				Login page
				</h1>
				<label><b>Username: </b></label> <input type="text" name="username">
				<br /> <label><b>Password: </b></label> <input type="password"
					name="password"> <br />
				<button type="submit" name="button">
					<b>LOGIN</b>
				</button>
				<a href="/register"> Register as new user</a>
		</div>
	</form>

</body>
<style>
h2 {
	color: #80ccff;
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
	border: 3px solid #80ccff;
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
a {
  color: #ffbf80;
}
</style>

</html>