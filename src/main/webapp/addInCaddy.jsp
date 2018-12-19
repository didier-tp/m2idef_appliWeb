<%@ page language="java" 
    import="java.util.List,java.util.ArrayList,
            com.m2i.tp.web.Selection,com.m2i.tp.entity.Produit"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
//on essaie de accéder à un caddy existant
listeSelections = (List<Selection>) session.getAttribute("caddy");
if(listeSelections==null){
	//on créer et stocke le caddy en session s'il n'existe pas encore
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
	nbElts=listeSelections.size();
}
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