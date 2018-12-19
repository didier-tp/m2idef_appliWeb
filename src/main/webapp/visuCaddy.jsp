<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<title>visuCaddy</title>
</head>
<body>
   <h3> contenu du caddy </h3>
   <table border="1">
      <tr><th>produit</th><th>quantite</th></tr>
      <c:forEach items="${sessionScope.caddy}" var="selection">
          <tr><td>${selection.produit}</td><td>${selection.quantite}</td></tr>
      </c:forEach>
   </table>
   <hr/>
   <a href="addInCaddy.jsp">autre ajout dans caddy</a>
   <%@ include file="piedPage.jsp" %>
</body>
</html>