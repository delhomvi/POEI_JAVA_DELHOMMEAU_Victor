<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<h1>Remplissez le nom et mdp</h1>
	<div>
		<p>Remplissez le formulaire suivant</p>
		<form action="RESexoMDP" method="GET">
			<label>Uset:</label> 
			<input name="user" value="user"/>
			<label>password:</label> 
			<input name="password" value="password" type="text" /> 
			<button value="Go"></button>
		</form>
	</div>

</body>
</html>