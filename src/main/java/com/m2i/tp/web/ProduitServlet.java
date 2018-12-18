package com.m2i.tp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.dao.DaoProduitJdbc;
import com.m2i.tp.entity.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//<a href="./ProduitServlet">liste des produits (servlet+dao+jsp)</a><br/>
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoProduit daoProduit = new DaoProduitJdbc();
		String chNumCategorie=request.getParameter("numCategorie");
		Long numCategorie = (chNumCategorie==null)?1L:Long.parseLong(chNumCategorie);
		List<Produit> listeProduits = daoProduit.rechercherProduits(numCategorie);
		//on stocke dans l'objet "request" une association
		//entre le nom logique "listeProduits" et l'objet java listeProduits
		//Lorsque le rd.forward(request,response) aura été déclanché,
		//la page jsp pourra en interne appeler request.getAttribute("listeProduits");
		//pour accéder aux données préparées et à afficher.
		//request.setAttribute("listeProduits", listeProduits);
		HttpSession session = request.getSession();//accès à l'objet session "utilisateur"
		session.setAttribute("listeProduits", listeProduits);
		
		RequestDispatcher rd;
		rd=this.getServletContext().getRequestDispatcher("/produits.jsp");
		rd.forward(request, response);//effectuer une redirection vers la page jsp
		//tout l'affichage est ainsi déléguer à la page JSP.
		/*
		//ancienne version sans page jsp:
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>liste des produits</h3>");
		out.println("<table border='1'>");
		out.println("<tr><th>numero</th><th>label</th><th>prix</th></tr>");
		for(Produit prod : listeProduits) {
			out.println("<tr>");
				out.println("<td>"+ prod.getNumero() + "</td>");
				out.println("<td>"+ prod.getLabel() + "</td>");
				out.println("<td>"+ prod.getPrix() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
