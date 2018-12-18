<%@ page import="java.util.List,com.m2i.tp.entity.Produit" %>
<%
List<Produit> listeProduits = (List<Produit>)
                request.getAttribute("listeProduits");
%>
<html>
<head>
 <link rel="stylesheet" href="styles.css">
 <title>produits</title></head>
<body>
	<h3>** liste des produits **</h3>
	<table border="1">
	   <tr><th>numero</th><th>label</th><th>prix</th></tr>
	   <%for(Produit prod : listeProduits) { %>
	      <tr><td><%=prod.getNumero()%></td>
	          <td><%=prod.getLabel()%></td>
	          <td><%=prod.getPrix()%></td></tr>
	   <%}%>
	</table>
</body>
</html>