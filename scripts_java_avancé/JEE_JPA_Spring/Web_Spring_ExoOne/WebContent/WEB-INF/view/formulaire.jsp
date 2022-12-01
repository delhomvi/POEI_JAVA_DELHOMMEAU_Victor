<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Formulaire en ligne</title>
</head>
<body>
	<h1>Remplissez le formulaire suivant</h1>
	<div>
		<p>Remplissez le formulaire suivant</p>
		<form action="resultats" method="GET">
			<label>Nom:</label> 
			<input name="nom" value="nom"/>
			<label>Prenom:</label> 
			<input name="prenom" value="prenom" type="text" /> 
			<label>Age:</label> 
			<input name="age" value="age" type="text" />
			<button value="Go"></button>
		</form>
	</div>
</body>
</html>