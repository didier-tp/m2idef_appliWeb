<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"  
         pageEncoding="ISO-8859-1"
         import="java.util.List,java.util.ArrayList,
         com.m2i.tp.web.Selection,com.m2i.tp.entity.Produit"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html><head>
<title>addInCaddy</title>
</head>
<%!
Produit recupererProduitSelonNumero(HttpSession session,Long num){
	Produit prod=null;
	List<Produit> listeProduits = (List<Produit>)
			                  session.getAttribute("listeProduits");
	if(listeProduits!=null){
		for(Produit p: listeProduits){
			if(p.getNumero()==num){
				prod=p; break;
			}
		}
	}
	return prod;
}
%>

<% Integer nbElts = 0;
String chProduit = request.getParameter("produit");
System.out.println("produit="+chProduit);
List<Selection> listeSelections = null;
//on essaie de acc�der � un caddy existant
listeSelections = (List<Selection>) session.getAttribute("caddy");
if(listeSelections==null){
	//on cr�er et stocke le caddy en session s'il n'existe pas encore
	listeSelections =  new ArrayList<Selection>();
	session.setAttribute("caddy",listeSelections);
}
if(chProduit !=null){
	int qte = Integer.parseInt(request.getParameter("quantite"));
	Produit prod = recupererProduitSelonNumero(session,
												Long.parseLong(chProduit) 
												);
	Selection s = new Selection(prod,qte);
	listeSelections.add(s);
}
nbElts=listeSelections.size();
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
    <hr/>
    <a href="visuCaddy.jsp">visualiser le contenu du caddy</a>
   <%@ include file="piedPage.jsp" %>
</body>
</html>