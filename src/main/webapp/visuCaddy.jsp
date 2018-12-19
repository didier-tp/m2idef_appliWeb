<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.ArrayList,
         com.m2i.tp.web.Selection" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<title>visuCaddy</title>
</head>
<%
if(request.getParameter("vider")!=null){
	List<Selection> listeSelections = (List<Selection>) session.getAttribute("caddy");
	if(listeSelections!=null){
		listeSelections.clear();
	}
}
	
%>
<body>
   <h3> contenu du caddy </h3>
   <table border="1">
      <tr><th>produit</th><th>quantite</th></tr>
      <c:forEach items="${sessionScope.caddy}" var="selection">
          <tr><td>${selection.produit}</td><td>${selection.quantite}</td></tr>
      </c:forEach>
   </table>
   <hr/>
   <form>
       <input type="submit" name="vider" value="vider caddy" />
   </form>
   <hr/>
   <a href="addInCaddy.jsp">autre ajout dans caddy</a>
   <%@ include file="piedPage.jsp" %>
</body>
</html>