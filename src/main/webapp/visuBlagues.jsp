<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
 <link rel="stylesheet" href="styles.css">
 <title>blagues</title></head>
<body>
	<h3>*** liste des blagues ***</h3>
	<table border="1">
	   <tr><th>id</th><th>titre</th><th>texte</th><th>nbVotes</th><th>note moyenne</th><th>nouvelle note</th></tr>
	   <c:forEach items="${listeBlagues}" var="b">
	      <tr><td>${b.id}</td>
	          <td>${b.titre}</td>
	          <td>${b.texte}</td>
	          <td>${b.nbVotes}</td>
	          <td><fmt:formatNumber maxFractionDigits="2">${b.note}</fmt:formatNumber></td>
	          <td>
	             <a href="./BlagueServlet?task=noter&blagueId=${b.id}&nouvelleNote=1">1(--)</a> &nbsp;
	             <a href="./BlagueServlet?task=noter&blagueId=${b.id}&nouvelleNote=2">2(-)</a> &nbsp;
	             <a href="./BlagueServlet?task=noter&blagueId=${b.id}&nouvelleNote=3">3(-+)</a> &nbsp;
	             <a href="./BlagueServlet?task=noter&blagueId=${b.id}&nouvelleNote=4">4(+)</a> &nbsp;
	             <a href="./BlagueServlet?task=noter&blagueId=${b.id}&nouvelleNote=5">5(++)</a>
	           </td>
	       </tr>
	   </c:forEach>
	</table>
	<hr/>
	<a href="ajoutBlague.jsp">ajouter une nouvelle blague</a><br/>
	<%@ include file="piedPage.jsp" %>
</body>
</html>