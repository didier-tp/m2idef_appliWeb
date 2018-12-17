<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>calculTva</title>
</head>
<body>
   <%    double tva=0;   double ttc=0;
   String chHt= request.getParameter("ht"); //éventuellement null
   String chTauxTva= request.getParameter("tauxTva"); //éventuellement null
   if(chHt!=null && chTauxTva!=null){
	   //valeurs non nulles (après une saisie)
	   double ht = Double.parseDouble(chHt);
	   double tauxTva = Double.parseDouble(chTauxTva);
	   tva = ht * tauxTva/100;
	   ttc = ht + tva;
   }   %>
   <form method="post"> <!-- si pas de action="" quand on click sur "submit"  cette page jsp se rappelle elle meme -->
       ht : <input name="ht" value="<%=chHt%>" /> <br/>
       tauxTva : <input name="tauxTva" value="<%=chTauxTva%>" /> <br/>
       <input type="submit" value="calculer tva" />
   </form>   <hr/>
   tva=<%=tva%>  <br/>
   ttc=<%=ttc%>  <br/>
   <%@ include file="piedPage.jsp" %>
</body>
</html>