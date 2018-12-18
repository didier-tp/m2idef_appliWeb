<%@ page import="java.util.List,com.m2i.tp.entity.Categorie" %>
<%
List<Categorie> listeCategories = (List<Categorie>)
                request.getAttribute("listeCategories");
%>
<html>
<head>
 <link rel="stylesheet" href="styles.css">
 <title>categories</title></head>
<body>
	<h3>** liste des categories **</h3>
	<ul>
	   <%for(Categorie cat : listeCategories) { %>
	      <li>
	        <a href="./ProduitServlet?numCategorie=<%=cat.getId()%>">
	      [<%=cat.getId()%>] <%=cat.getLabel()%>
	        </a>
	      </li>
	   <%}%>
	</ul>
</body>
</html>