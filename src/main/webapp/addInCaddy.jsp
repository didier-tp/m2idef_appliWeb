<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addInCaddy</title>
</head>
<% Integer nbElts = 0;
String chProduit = request.getParameter("produit");
System.out.println("produit="+chProduit);
%>
<body>
    <form method="post"> 
       <!-- sans action la page se rappelle elle meme -->
        produit: <select name="produit">
                    <c:forEach items="${listeProduits}" var="prod">
                         <option value="${prod.numero}" >
                            ${prod.label} , ${prod.prix} euros</option>
                    </c:forEach>
                 </select> <br/>
        quantite: <input name="quantite" value="1" /> <br/>
        <input type="submit" value="ajouter dans caddy" />
    </form>
    <hr/>
    nombre de lignes dans le caddy = <%=nbElts%>
</body>
</html>