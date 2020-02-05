<html>
<head>


</head>
<body>
   <form method = "get" action="/userMenu">
	<div>
		<h2 style="font-family: courier;" align="center">MENU</h2>
		<ul>
			<li><a href="/pizzas">Choose pizza</a></li>
			<li><a href="/sauces">Choose sauces</a></li>
			<li><a href="/drinks">Choose drinks</a></li>
			<li><a href="/shoppingCart-detail-page">Shopping cart</a></li>
			<li><a href="/prevoiusOrder">Repeat a previous order</a></li>
		</ul>

	</div>
    </form>
</body>

<style>
h2 {
	color: #ffcc00;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #ffcc00;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
	font-family: courier;
	text-align: center;
}

li a:hover {
	background-color: #555;
	color: white;
}

div {
	border-radius: 12px;
	margin: auto;
	width: 15%;
	border: transparent;
	padding: 30px;
	background-color: #1a0100;
	background-image:
		url("https://transparenttextures.com/patterns/tileable-wood-colored.png");
}
</style>
</html>