<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <link rel="stylesheet" href="styles.css">
 <title>blagues</title></head>
<body>
	<h3>*** liste des blagues ***</h3>
	<table border="1">
	   <tr><th>id</th><th>titre</th><th>texte</th><th>note moyenne</th><th>nouvelle note</th></tr>
	   <c:forEach items="${listeBlagues}" var="b">
	      <tr><td>${b.id}</td>
	          <td>${b.titre}</td>
	          <td>${b.texte}</td>
	          <td>${b.note}</td>
	          <td>...</td>
	       </tr>
	   </c:forEach>
	</table>
	<hr/>
	<a href="ajoutBlague.jsp">ajouter une nouvelle blague</a><br/>
	<%@ include file="piedPage.jsp" %>
</body>
</html>