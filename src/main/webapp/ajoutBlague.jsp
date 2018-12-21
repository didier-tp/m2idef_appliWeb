<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajoutBlague</title>
</head>
<body>
	<h3>nouvelle blague</h3>
	<form method="post" action="./BlagueServlet">
	    <input type="hidden" name="task" value="ajout" />
		titre : <input name="titre" /> <br/>
		texte : <textarea name="texte"></textarea> <br/>
		<input type="submit" value="ajouter blague" />
	</form>
</body>
</html>