<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <link rel="stylesheet" href="styles.css">
 <title>produits</title></head>
<body>
	<h3>*** liste des produits ***</h3>
	<table border="1">
	   <tr><th>numero</th><th>label</th><th>prix</th></tr>
	   <!-- ${listeProduits} ou bien ${requestScope.listeProduits} 
	        ou bien ${sessionScope.listeProduits}
	        avec request.getAttribute("listeProduits") automatique-->
	   <c:forEach items="${listeProduits}" var="prod">
	      <tr><td>${prod.numero}</td>
	          <td>${prod.label}</td>
	          <td>${prod.prix}</td></tr>
	   </c:forEach>
	</table>
	<hr/>
	<a href="addInCaddy.jsp">addInCaddy</a>
</body>
</html>